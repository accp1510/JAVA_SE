package ru.java.app1;

import java.util.Scanner;

/**
 * Created by Губин_Н on 13.04.2016.
 */

public class Start {
    public static void main(String[] args) {
        //сканнер для считывания входного потока
        Scanner sc = new Scanner(System.in);
        //прием слова из консоли
        String str = sc.next();
        //вывод результата в консоль
        System.out.println(str);
        str = sc.next();
        //вывод результата в консоль
        System.out.println(str);
        //прием всей строки
        str = sc.nextLine();
        System.out.println(str);
        //чтение целого числа
        try {

            int a = sc.nextInt();
            System.out.println(a);
        } catch (Exception ex) {
            System.out.println("Невозможно привести к числу введенную строку");
        }
        //массивы
        //Инициализация масива 10-ю элементами
        int[] arr1 = new int[10];
        //Заполнение массива
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i;
        }
        System.out.println("Заполенный массив от 0 до 9");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        //инициализации и заполение массива элементами
        int[] arr2 = {1, 2, 3, 7, 41, 89};
        System.out.println("\nМассив2 на " + arr2.length + " элементов\nСостоит из: ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

        //суммирование элементов
        int sum = 0;
        for (int i = 0; i < arr2.length; i++) {
            sum = sum + arr2[i];
        }
        System.out.println("\nСумма равна " + sum);
    }
}
