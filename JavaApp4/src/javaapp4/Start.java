
package javaapp4;

public class Start {

    public static void main(String[] args) {

        //создание объекта с помощью конструктора без параметров
        Car c1 = new Car();

        //просмотр значений полей у объекта с1
        System.out.println(c1.make);
        System.out.println(c1.color);

        //поле model не доступно из-за уроня доступа, поэтому используем геттер
        //System.out.println(c1.model);
        System.out.println(c1.getModel());

        //установка значений для полей объекта с1
        c1.make = "BMW";
        c1.color = "Black";
        //для поля model используем сеттер
        c1.setModel("M5");

        c1.printCar();

        //создание объекта с помощью конструктора с параметрами
        Car c2 = new Car("Lada", "Vesta", "White");
        System.out.println("У нас новый автомобиль");
        c2.printCar();

        System.out.println(c2.drive(1));
        System.out.println(c2.drive(2));
        System.out.println(c2.drive(5));
        System.out.println(c2.drive(0));
        System.out.println(c2.drive(-1));
        System.out.println(c2.drive(0));
    }
}
