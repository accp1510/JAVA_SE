package javaapp3;

import javafx.beans.binding.StringBinding;

/**
 * Created by Губин_Н on 18.04.2016.
 */
public class Start {
    public static void main(String[] args) {
        //создание строк
        String s1 = "Hello";
        String s2 = new String("Hello");
        //метод интерн пытается создать ссылку на уже существующюю строку
        String s3 = new String(new char[]{'H', 'e', 'l', 'l', 'o'}).intern();
        String s4 = String.valueOf("Hello");
        String s5 = "Hello";

        //стравнение ссылок
        System.out.println("стравнение ссылок");
        System.out.println("s1 == s2 " + (s1 == s2));
        System.out.println("s2 == s4 " + (s2 == s4));
        System.out.println("s3 == s4 " + (s3 == s4));
        System.out.println("s1 == s4 " + (s1 == s4));
        System.out.println("s1 == s5 " + (s1 == s5));

        //стравнение строк
        System.out.println("стравнение строк");
        System.out.println("s1 equals s2 " + s1.equals(s2));
        System.out.println("s2 equals s4 " + s2.equals(s4));
        System.out.println("s3 equals s4 " + s3.equals(s4));
        System.out.println("s1 equals s4 " + s1.equals(s4));
        System.out.println("s1 equals s5 " + s1.equals(s5));

        System.out.println("s1 начинается с Hel " + s1.startsWith("Hel"));
        System.out.println("s1 начинается с hel " + s1.startsWith("hel"));
        System.out.println("s1 начинается с App " + s1.startsWith("App"));
        System.out.println("s1 заканчивается на Hel " + s1.endsWith("Hel"));
        System.out.println("s1 заканчивается на App " + s1.endsWith("App"));

        System.out.println("s1 в нижнем регисте " + s1.toLowerCase());
        System.out.println("s1 в верхнем регисте " + s1.toUpperCase());

        System.out.println("В s1 содержится " + s1.length() + " символов");

        //обращение к символу стоящий на позиции
        for (int i = 0; i < s1.length(); i++) {
            //format отформатированная строка
            String s6 = String.format("[%d] символ равен %c\n", i, s1.charAt(i));
            System.out.printf(s6);
        }


        //конкатенация строк (склиевание)
        String s6 = s1 + s2;
        System.out.println("s1 + s2 " + s6);
        String s7 = s1.concat(s2);
        System.out.println("s1 concat s2 " + s7);
        String s8 = String.join("***", s1, s2, s6, s7);
        System.out.println("String.join(s1 , s2 , s6 , s7) " + s8);


        //выделение из строки подстроки
        String s9 = s8.substring(5);
        System.out.println("Из s8 выделяем подстроку начиная с шестого символа " + s9);
        String s10 = s8.substring(5, 8);
        System.out.println("Из s8 выделяем подстроку  начиная с 6 символа заканчивая 9 " + s10);

        //поиск подстроки и её замена на другую подстроку
        String s11 = s8.replace('H', '-');
        System.out.println("Заменяем символ Н на - : " + s11);
        String s12 = s8.replaceFirst("lo", "aaaaa");
        System.out.println("Заменяем первое вхождение  lo на аааа : " + s12);
        String s13 = s8.replaceAll("lo", "aaaaa");
        System.out.println("Заменяем все вхождения  lo на аааа : " + s13);

        //работа с изменяемыми строками
        StringBuilder builder = new StringBuilder();
        builder.append("Hell");
        System.out.println("Добавление " + builder.toString());
        builder.insert(1, "Wolrd");
        System.out.println("Вставка после первого символа " + builder.toString());
        builder.delete(5, 9);
        System.out.println("Удаление символов с 6-ого по 10-й " + builder.toString());

        //разделение строки на построки
        String[] s14 = s8.split("\\*\\*\\*");
        for (int i = 0; i < s14.length; i++) {
            System.out.println(s14[i]);
        }
        String s15 ="Раделяем предложения на слова, учитывая пробелы. точки и запятые";
        String[] s16 = s15.split("(\\s|\\.|,)+");
        for (int i = 0; i < s16.length; i++) {
            System.out.println(s16[i]);
        }

        System.out.println("Проверка на букву или цифру '1'" + Character.isLetterOrDigit('1'));
        System.out.println("Проверка на букву или цифру 'a'" + Character.isLetterOrDigit('a'));
        System.out.println("Проверка на букву или цифру ' '" + Character.isLetterOrDigit(' '));
    }
}
