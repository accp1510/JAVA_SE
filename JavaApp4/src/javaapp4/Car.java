//папка, в корой лежит класс
package javaapp4;

//название класса, для описание сущности автомобиля
public class Car {
    //строковое публичное поле
    public String color;
    //строковое публичное поле cо значение по умолчанию
    public String make = "Opel";
    //строковое защищенное поле (доступно внутри класса)
    private String model;

    //конструктор по умолчанию
    public Car() {
        //инициализация полей
        color = "Red";
        model = "Astra";
    }

    public Car(String make, String model, String color) {
        //инициализация полей
        //this - обращение к полю класса
        //без this - обращение к аргументу
        this.color = color;
        this.model = model;
        this.make = make;
    }

    //медот без возращаемого значения и без аргументов
    public void printCar() {
        System.out.println(make + " " + model + " " + color);
    }

    //сеттор (метод, который усатанавливает значение в поле)
    //метод с аргументом и без возращаемого значения
    public void setModel(String model) {
        this.model = model;
    }

    //геттор (метод, который возращает значение поля)
    //медот с возращаемым значением и без аргументов
    public String getModel() {
        return model;
    }

    public String drive(int perdacha) {
        if (perdacha > 0)
            return "Автомобиль поехал на " + perdacha + "передаче";
        if (perdacha == 0)
            return "Автомобиль остановился";
        return "Автомобиль покатился назад";
    }
    //инициализатор
    {
        System.out.println("Состояние поля make " +make);
        make = "Audi";
        System.out.println("Состояние поля make " +make);
    }
}
