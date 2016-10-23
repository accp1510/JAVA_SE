package javaapp5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Губин_Н on 22.04.2016.
 */
public class Car {
    //статичтное значимое поле поле
    public static int count;
    //cтатичное ссылочное поле
    public static Car car = new Car("Общий", "Общий");

    //значимая константа
    public static final int sizeRound = 16;

    //ссылочная константа (final)
    public static final List<Car> cars = new ArrayList<>();

    //статичный иничиализатор (выполняется при первом обращении к классу)
    static {
        System.out.println("Статичный инициализатор. Первое Обращение к классу Car и создадим автомобили");
        cars.add(new Car("Opel", "Astra"));
        cars.add(new Car("Zaz", "Chanche"));
        cars.add(new Car("LADA", "2101"));
        cars.add(car);

        System.out.println("Статичный инициализатор. Все автомобили созданы");
    }

    //статичный метод
    public static void countCars() {
        System.out.println("Всего " + cars.size() + " автомобилей\nРазмер их колес: " + sizeRound);
    }

    public String make;
    public String model;

    //Alt+Insrert
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
        System.out.println("Конструктор. Создание автомобиля "+this.toString());
    }

    @Override
    public String toString() {
        return "Марка " + make + " модель" + model;
    }

    {
        count++;
        System.out.println("Инициализатор. Увеличение количества автомобилей на единицу");
    }
}
