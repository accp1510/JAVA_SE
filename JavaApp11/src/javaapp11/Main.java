package javaapp11;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //байтовый поток на запись в файл
        FileOutputStream fileOutputStream = null;
        try {

            fileOutputStream = new FileOutputStream("c:/folder/test.out");
            String str = "Hello World";
            byte[] b = str.getBytes();
            //запись массива байт в файл
            fileOutputStream.write(b);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("В Файл не доспупен");
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    System.out.println("Невожно закрыть поток");
                }
            }
        }
        FileInputStream fileInputStream = null;
        InputStreamReader in = null;
        BufferedReader reader = null;
        try {
            fileInputStream = new FileInputStream("test1.out");
            in = new InputStreamReader(fileInputStream, "cp1251");
            reader = new BufferedReader(in);

            int c;
            //посимволное считывание из файла
//            while ((c = in.read()) != -1) {
//                System.out.println((char) c);
//            }

            //построчное считывание из файла


            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка чтения");
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    System.out.println("Ошибка закрытия потока");
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println("Ошибка закрытия потока");
                }
            }

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Ошибка закрытия потока");
                }
            }
        }

        PrintWriter printWriter = null;
        Scanner sc = null;
        try {
            printWriter = new PrintWriter(
                    new OutputStreamWriter(
                            new FileOutputStream("test2.txt", true), "cp1251"));
            sc = new Scanner(System.in);
            String s = null;

            while (!(s = sc.nextLine()).equals("end")) {
                printWriter.println(s);
                printWriter.flush();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
            if (sc != null) {
                sc.close();
            }
        }

        try {
            RandomAccessFile file = new RandomAccessFile("test2.txt", "rw");
            file.seek(5);
            byte[] b = "Helllooooooooo".getBytes("cp1251");
            file.write(b);
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Cat cat = new Cat("Мурка", "Белый");
        cat.addCat(new Cat("Мурзик", "Черный"));
        cat.addCat(new Cat("Рыжик", "Рыжий"));

        //сериализация объекта cat
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("cat.txt"));
            objectOutputStream.writeObject(cat);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Десериализация
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream("cat1.txt"));
            Cat cat1 = (Cat) objectInputStream.readObject();
            System.out.println(cat1);
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        File file = new File("test.out");
        String[] files = file.list();
        if (files != null)
            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i]);
            }
        System.out.println(file.getAbsolutePath());
        System.out.println("Размер файла " + file.length());
        file.delete();

    }
}
