package javaapp10;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //неупорядоченное множество
        HashSet hashSet = new HashSet();
        //добавление в множество
        boolean b = hashSet.add("Hello");
        System.out.println("Размер множества " + hashSet.size() + " " + b);
        b = hashSet.add("Hello");
        System.out.println("Размер множества " + hashSet.size() + " " + b);

        if (hashSet.contains("hello")) {
            System.out.println("hello содержится в множестве");
        } else {
            System.out.println("hello не содержится в множестве");
        }

        printCollection(hashSet.iterator(), "Элементы множества");
        hashSet.add(new HockeyTeam("Россия", 27, 10, 7));
        hashSet.add(new HockeyTeam("Канада", 25, 13, 9));
        hashSet.add(new HockeyTeam("Чехия", 12, 13, 12));
        printCollection(hashSet.iterator(), "Элементы множества");
        hashSet.add(new HockeyTeam("Россия", 27, 10, 7));
        printCollection(hashSet.iterator(), "Элементы множества");

        //удаление из множества
        hashSet.remove("Hello");
        hashSet.remove(new HockeyTeam("Канада", 25, 13, 9));
        printCollection(hashSet.iterator(), "Элементы множества после удаления");

        //сортрированное множество
        TreeSet treeSet = new TreeSet();
        //довавление элемента
        treeSet.add(new HockeyTeam("Россия  ", 27, 10, 7));
        treeSet.add(new HockeyTeam("Россия1 ", 27, 9, 5));
        treeSet.add(new HockeyTeam("Россия2 ", 27, 10, 6));
        treeSet.add(new HockeyTeam("Канада ", 25, 13, 9));
        treeSet.add(new HockeyTeam("Чехия  ", 12, 13, 12));
        printCollection(treeSet.iterator(), "Элементы сортированного множества ");

        //переход от сортированного множества к списку
        ArrayList arrayList = new ArrayList(treeSet);
        arrayList.addAll(hashSet);
        printCollection(arrayList.iterator(), "переход от сортированного множества к списку");

        //карта
        HashMap hashMap = new HashMap();
        HockeyTeam russia = new HockeyTeam("Россия  ", 27, 10, 7);
        //добавление ключа и значение в Mаp
        hashMap.put("Россия", russia);
        hashMap.put("Россия", russia);
        hashMap.put("Россия1", russia);

        //просмотр всех элементов Map
        for (Object item : hashMap.keySet()) {
            System.out.println("Ключ " + item);
            System.out.println("Значение " + hashMap.get(item));
        }
        //Удаление по ключу
        hashMap.remove("Россия1");
        System.out.println();
        for (Object item : hashMap.keySet()) {
            System.out.println("Ключ " + item);
            System.out.println("Значение " + hashMap.get(item));
        }
        //отсортированное по ключу карта
        TreeMap treeMap = new TreeMap();
        treeMap.put("Россия", russia);
        treeMap.put("Канада", new HockeyTeam("Канада ", 25, 13, 9));
        treeMap.put("Чехия", new HockeyTeam("Чехия  ", 12, 13, 12));

        System.out.println("Отсортированок по ключу TreeMap");
        for (Object item : treeMap.keySet()) {
            System.out.println("Ключ " + item);
            System.out.println("Значение " + treeMap.get(item));
        }

        printCollection(arrayList.iterator(), "Список");
        Collections.sort(arrayList);
        printCollection(arrayList.iterator(), "Остортированный список ");

        Collections.shuffle(arrayList);
        printCollection(arrayList.iterator(), "Перемешанный список ");

        //неисзменяемый список (представление для arrayList)
        List list = Collections.unmodifiableList(arrayList);
        //Нельзя добавить list.add("");
        //Нельзя удалить list.remove(0);
        //но можем работать с объектами на имеются ссылки
        ((HockeyTeam) list.get(0)).setName("Новая команда");
        printCollection(list.iterator(), "неисзменяемый список ");

       Object max = Collections.min(arrayList);
        Object min = Collections.max(arrayList);
        System.out.println("Команда первая в рейнинге "+max);
        System.out.println("Команда последняя в рейнинге "+min);
    }

    public static void printCollection(Iterator it, String message) {
        System.out.println(message);
        while (it.hasNext()) {
            System.out.println("Элемент " + it.next());
        }
    }
}
