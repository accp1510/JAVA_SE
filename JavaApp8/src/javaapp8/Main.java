package javaapp8;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        f1();
        try {
            f2();
        } catch (IOException e) {
            System.out.println("Все-таки обработали");
        }
    }

    private static void f1() {
        //в блок помещается код, который может генировать исключение
        try {
            Object o = new Object();
            //исключительная ситуация
            String str = (String) o;
        }
        //ошибки приветдения типа
        catch (ClassCastException e) {
            System.out.println("Невозможно что-то привести к чему-то");
        }
        //ошибки происходящии во время выполнения приложения
        catch (RuntimeException e) {
            System.out.println("Найдена ошибка во время выполнения");
        }
        //обрабатывает все найденные исключения
        catch (Exception e) {
            System.out.println("Найдена ошибка");
            System.out.println("e.getMessage " + e.getMessage());
            System.out.println("e.getLocalizedMessage " + e.getLocalizedMessage());
            System.out.println("e.fillInStackTrace " + e.fillInStackTrace());
            e.printStackTrace();
            //системный поток ошибок
            System.err.print("Поток ошибок");
        }
        //выполнятся в любом случае
        finally {
            System.out.println(" //выполнятся в любом случае");
        }
    }

    private static void f2() throws IOException {
        int count = -2;
        ClassA a;
        while (true) {
            try {
                a = new ClassA(count++);
                System.out.println("Файл Создан");
                break;
            } catch (IOException e) {
                System.out.println("Файла не существует. Ввети имя файла " + count);
            }
        }
        try {
            a.m1();
        } catch (NullPointerException e) {
        }

        try {
            a.m3();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

        a.m2();

    }
}
