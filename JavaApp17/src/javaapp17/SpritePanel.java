package javaapp17;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Губин_Н on 25.05.2016.
 */
public class SpritePanel extends JPanel {

    private int x;
    private int y;
    Color[] colors = new Color[10];
    private int currentColor = 0;
    private BufferedImage image;
    private int frameX;
    private int frameY;

    public SpritePanel() {
        this.setBackground(Color.white);
        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                x += 5;
                y += 5;

            }
        });
        timer.start();
        for (int i = 0; i < colors.length; i++) {
            colors[i] = Color.getHSBColor(0.5f, 0.5f, 0.1f * i);
        }

        Timer colorTimer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                currentColor++;
                if (currentColor >= colors.length) {
                    currentColor = 0;
                }
                //frameY=1;
                frameY++;
                if (frameY == 3)
                    frameY = 0;

                //перерисовать панель
                repaint();
            }
        });
        colorTimer.start();
        try {
            image = ImageIO.read(new File("angry_birds.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.setColor(this.getBackground());
        graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
//        graphics.setColor(colors[currentColor]);
//        graphics.fillRect(x, y, 100, 100);
        graphics.drawImage(image.getSubimage(100 * frameX, 100 * frameY, 100, 100), x, y, null);
    }
}
