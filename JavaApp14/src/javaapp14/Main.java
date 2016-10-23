package javaapp14;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //класс-обёртка для типa int
        Integer i = new Integer(5);
        Integer i1 = 6;

        //класс-обёртка для типa short
        Short s = new Short((short) 68);

        //класс-обёртка для типa byte
        Byte b = new Byte((byte) 255);

        //класс-обёртка для типa long
        Long l = new Long(100L);

        //класс-обёртка для типa double
        Double d = new Double(10.0);

        //класс-обёртка для типa float
        Float f = new Float(15.0f);

        //класс-обёртка для типa boolean
        Boolean bool = new Boolean(true);

        //класс-обёртка для типa char
        Character c = new Character('Z');

        //родиетельский класса для числовых оберток
        Number n = i;

        if (Character.isUpperCase(c)) {
            System.out.println("С большой буквы");
        } else {
            System.out.println("С маленькой буквы");
        }

        //к объектам класса-оберток можно присвоить null
        Integer a = null;
        //к примитивам нельзя
        int a1 = 0;


        //в переменной intData будут хранится только значения типа Integer
        BoxData<Integer> intData = new BoxData<Integer>();
        //разрешено добавление
        intData.add(new Integer(5));

        //запрещено добваление  intData.add("123");

        intData.add(new Integer(6));
        intData.print();

        intData.add(new Integer(9));

        int sum = 0;
        for (int j = 0; j < 3; j++) {
            int o = intData.item(j);
            sum += o;
        }
        System.out.println(sum);
        intData.print();

        //в переменной stringBoxData будут хранится только значения типа String
        BoxData<String> stringBoxData = new BoxData<>();
        stringBoxData.add("123");

        ArrayList<Float> floats = new ArrayList<>();


        BoxData<Parent> parentBoxData = new BoxData<>();
        parentBoxData.add(new Parent());
        parentBoxData.add(new Child());
        parentBoxData.add(new Parent());

        parentBoxData.print();

        Integer[] integers = new Integer[10];
        fillArray(integers, 10);

        Parent parent = new Parent();
        parent.name = "name1";
        someMethod(parent);

        Child child = new Child();
        child.name = "child name1";
        someMethod(child);

        //? - маска (Wildcard)
        BoxData<?> boxData = new BoxData<Parent>();
        BoxData<Object> boxData1 = new BoxData<>();
        BoxData boxData2 = new BoxData();
        BoxData<Child> childBoxData = new BoxData<>();

        someMethod1(boxData1);
        someMethod1(parentBoxData);
        //не вополнится, так как стоит ограничение вверх someMethod1(childBoxData);
    }

    //универсальный метод
    public static <T> void fillArray(T[] arr, T value) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = value;
        }
    }

    //универсальный метод на два универсальных класса
    public static <T, E> void printMessage(T sender, E message) {
        System.out.println("Sender " + sender + " message " + message);
    }


    //ограничение универсального типа вниз, т.е. Parent либо Child
    public static <T extends Parent> void someMethod(T t) {
        // нельзя создать экземпляр универсального типа  T a = new T();
        String name = t.name;
        System.out.println("parent name " + name);
    }

    //ограничение универсального типа вверх, т.е. Оbject либо Parent
    public static void someMethod1(BoxData<? super Parent> t) {
        System.out.println(t.toString());
    }
}
