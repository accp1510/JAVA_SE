package com.example.javaapp.javaapp18;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class TouchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }

    class MyView extends View {

        float xRect = 100;
        float yRect = 100;

        boolean drag = false;
        float xDrag;
        float yDrag;

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float xEvt = event.getX();
            float yEvt = event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (xEvt >= xRect && xEvt <= xRect + 50
                            && yEvt >= yRect && yEvt <= yRect + 50) {
                        drag = true;
                        xDrag = xEvt - xRect;
                        yDrag = yEvt - yRect;
                    }
                    break;
                case MotionEvent.ACTION_MOVE:
                    if (drag) {
                        xRect = xEvt - xDrag;
                        yRect = yEvt - yDrag;
                        invalidate();
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    drag = false;
                    break;
                default:
                    break;

            }
            return true;
        }

        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Paint p = new Paint();

            p.setColor(Color.WHITE);
            canvas.drawRect(0,0,getWidth(),getHeight(),p);
            p.setColor(Color.GREEN);
            canvas.drawRect(xRect, yRect, 50f + xRect, 50f + yRect, p);
        }
    }
}
