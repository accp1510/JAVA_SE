package javaapp15;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        System.out.println("---перечисления---");
        methThreadState(ThreadStateEnum.START);
        methThreadState(ThreadStateEnum.RUNNING);
        methThreadState(ThreadStateEnum.WAITING);
        methThreadState(ThreadStateEnum.RUNNING);
        methThreadState(ThreadStateEnum.DEAD);


        System.out.println("---константы---");
        methThreadState(0);
        methThreadState(1);
        methThreadState(2);
        methThreadState(3);
        methThreadState(4);
        methThreadState(5);

        System.out.println(ThreadStateEnum.START.ordinal());
        System.out.println(ThreadStateEnum.DEAD.ordinal());

        //формы задания перемееной типа перечисления
        ThreadStateEnum threadStateEnum = ThreadStateEnum.START;
        ThreadStateEnum threadStateEnum1 = Enum.valueOf(ThreadStateEnum.class, "DEAD");
        ThreadStateEnum threadStateEnum2 = ThreadStateEnum.valueOf("RUNNING");

        System.out.println(threadStateEnum.toString());
        System.out.println("Перечисление " + threadStateEnum.getDescription() +
                " приоритет равен " + threadStateEnum.getPriority());
        System.out.println("Перечисление " + threadStateEnum1.getDescription() +
                " приоритет равен " + threadStateEnum1.getPriority());
        System.out.println("Перечисление " + threadStateEnum2.getDescription() +
                " приоритет равен " + threadStateEnum2.getPriority());
        ThreadStateEnum[] enums = ThreadStateEnum.values();
        for (int i = 0; i < enums.length; i++) {
            System.out.println(enums[i].toString());
        }

        ClassA a = new ClassA();
        a.method("");
        ClassB b = new ClassB();
        b.method("");

        Date d = new Date();
        if (ClassA.class.isAnnotationPresent(MethInfo.class)) {
            System.out.println("Класс " + ClassA.class.getName() + " содержит аннотацию");
            Annotation[] annotations = ClassA.class.getAnnotations();
            for (int i = 0; i < annotations.length; i++) {
                System.out.println(ClassA.class.getName()
                        + " имеет аннотацию " + annotations[i].toString());
                if (annotations[i] instanceof MethInfo) {
                    MethInfo m = (MethInfo) annotations[i];
                    System.out.println(ClassA.class.getName()
                            + " имеет версию " + m.version()
                            + " последнее изменени " + m.date());
                }
            }

        } else {
            System.out.println("Класс " + ClassA.class.getName() + " не содержит аннотацию");
        }
        System.out.println();
        Method[] methods = ClassA.class.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println("Метод " + methods[i].toString());
            Method m = methods[i];
            Annotation[] annotations = m.getAnnotations();
            for (int j = 0; j < annotations.length; j++) {
                System.out.println(m.getName()
                        + " имеет аннотацию " + annotations[j].toString());
                if (annotations[j] instanceof MethInfo) {
                    MethInfo annotation = (MethInfo) annotations[j];
                    System.out.println(m.getName()
                            + " имеет версию " + annotation.version()
                            + " последнее изменени " + annotation.date());
                }
            }
            System.out.println();
        }

    }

    public static void methThreadState(ThreadStateEnum state) {
        if (state == ThreadStateEnum.START)
            System.out.println("Поток запущен");
        if (state == ThreadStateEnum.RUNNING)
            System.out.println("Поток работает");
        if (state == ThreadStateEnum.WAITING)
            System.out.println("Поток приостановлен");
        if (state == ThreadStateEnum.DEAD)
            System.out.println("Поток завершил выполение");

    }

    public static void methThreadState(int state) {
        if (state == ThreaStatesConstClass.START)
            System.out.println("Поток запущен");
        if (state == ThreaStatesConstClass.RUNNING)
            System.out.println("Поток работает");
        if (state == ThreaStatesConstClass.WAITING)
            System.out.println("Поток приостановлен");
        if (state == ThreaStatesConstClass.DEAD)
            System.out.println("Поток завершил выполение");
    }
}
