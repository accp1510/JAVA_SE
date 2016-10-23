package ru.javaapp19;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Губин_Н on 30.05.2016.
 */
public class Starter {
    static ArrayList arrayList = new ArrayList();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello World");
        while (true) {
            String menu = sc.nextLine();
            if (menu.equals("0")) {
                System.out.println("Завершение работы");
                return;
            } else if (menu.equals("1")) {
                System.out.println("Добавляем объект в лист");
                arrayList.add(new byte[10 * 1024 * 1024]);
            } else if (menu.equals("2")) {
                arrayList.remove(arrayList.size() - 1);
                System.gc();
            }else {
                System.out.println("Неверная команда");
            }


        }


    }
}
