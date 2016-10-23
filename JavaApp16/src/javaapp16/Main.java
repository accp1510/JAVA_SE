package javaapp16;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //   createTable();
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");

            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            String[] params = str.split(" ");
            int i = Integer.parseInt(params[0]);
            int a = Integer.parseInt(params[2]);
            //выключение автоматической завершении транзакции
            c.setAutoCommit(false);

            //запрос на вставку в таблицу
            //? - параметр
            String sqlInsert = "INSERT INTO STUDENTS " +
                    "(ID, NAME, AGE, PHONE) " +
                    "values (?,?,?,?)";


            Statement statement = null;

            //объект запроса с параметрами
            PreparedStatement preparedStatement = c.prepareStatement(sqlInsert);
            //заполниение зничениями параметры
            preparedStatement.setInt(1, i);
            preparedStatement.setString(2, params[1]);
            preparedStatement.setInt(3, a);
            preparedStatement.setString(4, params[3]);

            //выполнение запроса
            int cRow = preparedStatement.executeUpdate();
            System.out.println("Изменилось " + cRow);
            preparedStatement.close();

            String sql = "UPDATE STUDENTS set age = 18 where age> 18";
            statement = c.createStatement();
            cRow = statement.executeUpdate(sql);

            if (cRow==0) {
                //фиксация изменения
                c.commit();
            } else {
                //откат изменений
                c.rollback();
            }

            String sqlSelect = "select id, name, age, phone from STUDENTS";
            statement = c.createStatement();

            //выполняем select из таблицы
            //метод executeQuery возвращает объект типа ResultSet (по принципу работы похож на курсор)
            ResultSet rs = statement.executeQuery(sqlSelect);
            // с помощью цикла проходимся по всем найденным записям
            while (rs.next()) {
                //читаем записи из просматриваемой строки
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt("age");
                String phone = rs.getString("phone");
                System.out.println(id + " " + name + " " + age + " " + phone);
            }
            statement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable() {
        Connection c = null;
        try {
            //загрузка драйвера для поключения к БД
            Class.forName("org.sqlite.JDBC");
            //соединение с БД
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("БД создалась");

            //описание запроса на создание таблица
            String sql = "CREATE TABLE STUDENTS (" +
                    "ID INT PRIMARY KEY, " +
                    "NAME TEXT, " +
                    "AGE INT, " +
                    "PHONE TEXT)";
            //создание объекта для вызова команд
            Statement statement = c.createStatement();
            //выполнение sql-команды
            statement.execute(sql);
            //закрытие потока
            statement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
