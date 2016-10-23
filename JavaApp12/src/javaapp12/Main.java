package javaapp12;

public class Main {

    public static void main(String[] args) {

        DOMParser parser = new DOMParser();

        try {

//            parser.createDocument();
//
//
//            Car car1 = new Car("BMW", "X5");
//            parser.addCar(car1);
//
//            car1 = new Car("Opel", "Astra");
//            parser.addCar(car1);
//
//            car1 = new Car("Lada", "Niva");
//            parser.addCar(car1);
//
//            Cat cat = new Cat("Мурзик", true);
//            parser.addCat(cat, "BMW");
//
//            cat = new Cat("Рыжик", false);
//            parser.addCat(cat, "BMW");
//
//            parser.addCat(cat, "Opel");
//
//
//            parser.saveDocument("test.xml");

            parser.createDocument("test.xml");
            parser.printDocument();


        } catch (Exception e) {
            System.out.println("Ошибка");
            e.printStackTrace();
        }
    }
}
