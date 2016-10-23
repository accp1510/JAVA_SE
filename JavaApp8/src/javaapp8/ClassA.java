package javaapp8;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Губин_Н on 29.04.2016.
 */
public class ClassA {

    public void m1() {
        /*
        Важный код
         */
        //ручное генерирование исключения
        throw new NullPointerException();
        /*
        Важный код
         */
    }

    //throws показывает что медот может сгенирировать исключение типа IOException
    public void m2() throws IOException {

        throw new IOException();
    }

    //в конструкторе тоже можно генерировать исключения
    public ClassA(int a) throws IOException{
        if (a < 0) {
            throw new IOException();
        }
    }

    public void m3() throws MyException {

        //генерация собственного исключения
        throw new MyException("Какая-то важная ошибка", this, new Date());

    }
}
