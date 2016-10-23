package javaapp8;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Губин_Н on 29.04.2016.
 */
public class ClassB extends  ClassA{
    public ClassB(int a) throws IOException {
        super(a);
    }

    //при переопределении метода запрещеное добавлять в throws новый вид иключения,
    // отличный от исключений в родительском метода
    public void m2() throws IOException/*, MyException*/ {
        super.m2();

    }
}
