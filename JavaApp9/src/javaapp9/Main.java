package javaapp9;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Object[] o = new Object[10];
        //заполенение массив о значение Hello
        Arrays.fill(o, "Hello");
        for (int i = 0; i < o.length; i++) {
            System.out.println(o[i]);
        }
        //заполенение массив о значение World c 1 по 4 ячейку
        Arrays.fill(o, 0, 4, "World");
        System.out.println();
        for (int i = 0; i < o.length; i++) {
            System.out.println(o[i]);
        }
        //создание копии массива
        Object[] o1 = Arrays.copyOf(o, 20);
        System.out.println("Новый массив");
        for (int i = 0; i < o1.length; i++) {
            System.out.println(i + " " + o1[i]);
        }

        //создание копии массива из диапозана значений из 3-5 ячеек
        Object[] o2 = Arrays.copyOfRange(o, 3, 6);
        System.out.println("Новый массив2");
        for (int i = 0; i < o2.length; i++) {
            System.out.println(i + " " + o2[i]);
        }

        Cat cat = new Cat();
        cat.name = "Мурка";

        Cat[] cats = new Cat[5];
        Arrays.fill(cats, cat);
        printArray(cats, "Массив кошек");
        cat.name = "Вася";
        printArray(cats, "Массив кошек. Изменили имя у одной кошки");

        //Копируются только значения ячееек маасива, в данном случае ссылки
        Cat[] cats2 = Arrays.copyOf(cats, cats.length);
        printArray(cats2, "Скопированый массив кошек");

        Random random = new Random(System.currentTimeMillis());
        String[] alph = new String[10];
        for (int i = 0; i < alph.length; i++) {
            alph[i] = Character.toString((char) (random.nextInt(26) + 65));
        }
        printArray(alph, "Массив букв");
        //сортировка массив
        Arrays.sort(alph);
        printArray(alph, "Отсортированный массив букв");
        //поиск элемента в массиве
        int n = Arrays.binarySearch(alph, "A");
        if (n < 0) {
            System.out.println("Буква А не найдена");
        } else {
            System.out.println("На позиции " + n + " находится " + alph[n]);
        }


        //Список на основе масива
        ArrayList arrayList = new ArrayList();

        //добавление элемента в массив
        arrayList.add(cat);
        arrayList.add(cat);
        arrayList.add(new Cat());
        arrayList.add("Hello");
        printIterator(arrayList, "Печать ArrayList");
        //обращение к элементу по его номеру
        Object o4 = arrayList.get(0);
        System.out.println("На позиции 0 находится " + o4);
        if (o4 instanceof Cat) {
            Cat c = (Cat) o4;
            System.out.println("Имя кошки " + c.name);
        } else {
            System.out.println(o4 + " не кошка");
        }
        //количество элементов в массиве
        int size = arrayList.size();
        System.out.println("В массиве элементов " + size);
        arrayList.add(new Cat());
        size = arrayList.size();
        System.out.println("В массиве элементов " + size);

        arrayList.remove(4);
        arrayList.remove(3);
        printIterator(arrayList, "Печать ArrayList после удаление двух элементов");

        Object o5 = arrayList.get(0);
        //удаляет первую найденную ссылку
        arrayList.remove(o5);
        arrayList.remove(o5);
        printIterator(arrayList, "Печать ArrayList после удаление через ссылку");

        //ссылочный список
        LinkedList linkedList = new LinkedList();
        linkedList.add("Add");
        linkedList.addFirst("AddFirst");
        linkedList.addLast("AddLast");
        linkedList.add(1, "Insert2");
        printIterator(linkedList, "Печать LinkedList");

        //списочный итератор. инератор ссылается на 4 элемент
        ListIterator it = linkedList.listIterator(3);
        //передвигаем инератор на предыдущий
        System.out.println("Предыдущий элемент " + it.previous());
        //удаляем элемент на который ссылается итератор и итератор ссылается на следующий (AddLast)
        it.remove();
        //передвигаем инератор на предыдущий (Insert2)
        System.out.println("После удаление Add предыдущий  элемент " + it.previous());
        //заменяем значение текущего элемента, на который ссылается итератор
        it.set("ListIterator");

        printIterator(linkedList, "Печать LinkedList после итератора");

        Collections.sort(linkedList);
        printIterator(linkedList, "Печать LinkedList после сортировки");
        linkedList.add("b");
        linkedList.add("a");
        linkedList.add("bqweqetedgfdgb");
        linkedList.sort(new CompareString());
        printIterator(linkedList, "Печать LinkedList после новой сортировки ");

    }

    private static void printIterator(Collection arrayList, String name) {
        System.out.println(name);
        //Работа итератором. Получение итератора
        Iterator it = arrayList.iterator();
        //Есть что считать из итератора
        while (it.hasNext()) {
            //Считывает следующий элемент из итератора
            Object o3 = it.next();
            System.out.println("Элемент " + o3);
        }
    }

    //печать всего массива в консоль
    public static void printArray(Object[] objects, String name) {
        System.out.println(name);
        for (int i = 0; i < objects.length; i++) {
            System.out.println(i + " " + objects[i]);
        }
    }
}
