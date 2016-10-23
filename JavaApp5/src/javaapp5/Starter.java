package javaapp5;

/**
 * Created by Губин_Н on 22.04.2016.
 */
public class Starter {

    public static void main(String[] args) {
        System.out.println("Hello");
        
        //обращение к статичной переменной
        System.out.println("count = " + Car.count);
        System.out.println("меняем count ");
        Car.count = 4;
        //обращение к статичной переменной
        System.out.println("count = " + Car.count);

        //Обращение к константе
        System.out.println("sizeRound = " + Car.sizeRound);
        //значение изменить не можем
        //не пройдет Car.sizeRound=10;

        //Обращение к ссылочной константе. Можно обращаться к методам и полям объекта,
        //на который ссылается константа.
        System.out.println("количество автомобилей " + Car.cars.size());
        //Запрещено изменять ссылку константы
        // не пройдет Car.cars = new LinkedList<>();

        //обращение к статичному методу
        Car.countCars();

        //обращение к ссылочной стачной переменной (Car.car)
        System.out.println(Car.car.toString());
        //изменяем поле у объекта, которое ссылается поле car
        Car.car.model = "Juke";
        System.out.println(Car.car.toString());
        //заменяем ссылку у переменной car
        Car.car = new Car("LADA", "NIVA");
        Car.cars.add(Car.car);
        System.out.println(Car.car.toString());

        System.out.println("count " + Car.count);
        System.out.println("count cars " + Car.cars.size());
        System.out.println(Car.cars.toString());
    }
}
