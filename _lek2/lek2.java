/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testapp2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Губин_Н
 */
public class TestApp2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //вывод в консоль
        System.out.print("любой объект");
        //вывод в консоль, после вывода курсор переноситься на новую строку
        System.out.println("любой объект");
        System.out.println("любой объект с новой строки");


        //сканнер читает данные из консоли
        Scanner scaner = new Scanner(System.in);

        //читает слово до пробела. остальную часть строки, введенной в консоли, остается в буфере
        //если буфер пустой, то прорамма ожидает ввода из консоли
        String s = scaner.next();
        //читает следущее слово из буфера
        s = scaner.next();
        //проверка на нахождение данных в буфере
        boolean b = scaner.hasNext();

        //блок ветвления if (принимает логическое условие)
        if (b) {
            //если условие истино, то выполняется первая ветвь
            System.out.println("Есть слово в буфере");
        } else {
            //если условие ложно, то выполняется вторая ветвь
            System.out.println("Буфер пустой");
        }

        //считываем число из консоли
        try {
            int i = scaner.nextInt();
            System.out.println("Введенное число " + i);
        } catch (Exception e) {
            System.out.println("Вы ввели строку и это не число, пока! ");
        }

        //бесконечный цикл. работает до тех пор пока пользователь не введ число
        while (true) {
            try {
                //считываем строку из консоли
                String str = scaner.nextLine();
                //введенную строку конвертируем в число
                int i = Integer.parseInt(str);
                System.out.println("Введенное число " + i);
                break;
            } catch (Exception e) {
                System.out.println("Вы ввели строку и это не число, повторите ввод! ");
            }
        }

        do {
            System.out.println("Выполнится хотя бы один раз");
        } while (false);

        int sum = 0;
        //цикл со счетчиком (от 0 до 10)
        for (int i = 0; i < 10; i++) {
            sum += i;
            System.out.println("Сумма " + i + " элементов равна " + sum);
            //Оператор множественного ветвления 
            switch (i) {
                case 1:
                    System.out.println("Понедельник");
                    break;
                case 2:
                    System.out.println("Bторник");
                    break;
                case 3:
                    System.out.println("Среда");
                    break;
                case 4:
                    System.out.println("Четверг");
                    break;
                case 5:
                    System.out.println("Пятница");
                    break;
                case 6:
                    System.out.println("Суббота");
                    break;
                case 7:
                    System.out.println("Воскресение");
                    break;
                default:
                    System.out.println("Для " + i + " дня нет дня недели");
            }
        }
//проверка равенство строк только через equals
        String s1 = "Hello";
        String s2 = "Hello";
        if (s1.equals(s2)) {
            System.out.println("Строки равны");
        } else {
            System.out.println("Строки не равны");
        }
//  // старвнение ссылок, у s1 и s2 одинаковые ссылки, поэтому результатом будет "Строки равны"
        if (s1 == s2) {
            System.out.println("Строки равны");
        } else {
            System.out.println("Строки не равны");
        }

        String s3 = new String("Hello");
        // старвнение ссылок, у s1 и s3 разные ссылки, поэтому результатом будет "Строки не равны"
        if (s1 == s3) {
            System.out.println("Строки равны");
        } else {
            System.out.println("Строки не равны");
        }

        //любое положительное число
        int count = 10;
        //создание числовог омассива на count элементов
        //все ячеки маасива заполнились нулями
        //arr.length поле в котором содержиться количество элементов
        int[] arr = new int[count];

        for (int i = 0; i < arr.length; i++) {
            //Форматированный вывод (как в Си)
            //arr[i] обращение к i-ому элементу
            System.out.println(String.format("[%d] = %d", i, arr[i]));
        }

        //заполнение случайным образом
        //Класс Random может генирировать числа случайным образом
        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < arr.length; i++) {
            //записываем в i-ую ячейку массива arr случайное значение от 0 до 99
            arr[i] = rand.nextInt(100);
        }
        System.out.println("\n Заполенный случайными значениями массив");
        for (int i = 0; i < arr.length; i++) {
            //Форматированный вывод (как в Си)
            //arr[i] обращение к i-ому элементу
            System.out.println(String.format("[%d] = %d", i, arr[i]));
        }



    }
}
