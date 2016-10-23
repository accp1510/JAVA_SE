package javaapp7;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Car c = new Car("Opel", "Astra");
        c.print();
        c.drive(100, 0.5f);
        System.out.println();

        Sedan sedan = new Sedan("Lada", "Priora");
        sedan.print();
        sedan.drive(190, 1.5f);
        sedan.drive(100, 111.5f);
        sedan.drive(190, 10.5f);
        System.out.println("Всего пройдено " + sedan.getDistance() + " км");
        System.out.println();

        Unversal unversal = new Unversal("BMW", "X5");
        unversal.print();
        unversal.drive(250, 0.1f);
        unversal.drive(20, 0.1f);
        unversal.drive(270, 0.1f);
        unversal.drive(10, 0.1f);
        System.out.println("Самая высокая скорость " + unversal.getMaxSpeed() + " км/ч");


        Car[] cars = new Car[10];
        //Класс для генерации случайных чисел
        Random random = new Random(System.currentTimeMillis());
        //Инициализаяция массива случайными автомобилями
        for (int i = 0; i < cars.length; i++) {
            //случайное целое число от 0 до 2
            int n = random.nextInt(3);
            //Ссылка на создаваемый автомобиль
            Car car = null;
            switch (n) {
                case 0:
                    car = new Car("Opel", "Astra");
                    break;
                case 1:
                    //Важно!!! В ссылку типа Car Помещаем объект типа Sedan
                    car = new Sedan("Lada", "Priora");
                    break;
                case 2:

                    Unversal u=  new Unversal("BMW", "X5");
                    //Важно!!! В ссылку типа Car Помещаем объект типа Unversal
                    car = u;
                    break;
            }
            //помещаем ссылку в массив
            cars[i] = car;
        }

        System.out.println();
        //напечаем заполненный массив автомобилей
        for (int i = 0; i < cars.length; i++) {
            cars[i].print();
        }

        for (int i = 0; i < cars.length; i++) {
            int n = random.nextInt(100);
            for (int j = 0; j < n; j++) {
                cars[i].drive(random.nextInt(250), random.nextFloat());
            }
        }

        for (int i = 0; i < cars.length; i++) {
            Car car = cars[i];
            //instanceof проверяет, принадлежит ли объект cars[i] к классу Sedan
            if (car instanceof Sedan) {
                //приводим тип ссылки Car к типу Sedan
                Sedan s = (Sedan) car;
                s.print();
                System.out.println("Всего пройдено " + s.getDistance() + " км");
            }
            //instanceof проверяет, принадлежит ли объект cars[i] к классу Unversal
            if (car instanceof Unversal) {
                Unversal s = (Unversal) car;
                s.print();
                System.out.println("Максимальная скорость " + s.getMaxSpeed() + " км/ч");
            }
            if (cars[i] instanceof Car) {
                System.out.println("This is car");
            }
        }

    }
}
