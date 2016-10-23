package javaapp6;

//Базовый класс
public class Cat extends Animal {
    //поля
    public String name;
    public int height;
    public int width;
    public int length;

    //метод
    public void live() {
        System.out.println("Гуляет сам по себе");
    }

    public Cat() {
        name = "Обычный";
        height = 15;
        width = 10;
        length = 25;
        //ссылка на поле абстрактного класса
        super.eat = "мясо";
    }

    public Cat(String name, String eat) {
        //Вызов конструктора без параметров
        this();
        this.name = name;
        //ссылка на поле абстрактного класса
        this.eat = eat;
    }

    public Cat(String name, String eat, int height, int width, int length) {
        //Вызов конструктора с одним параметром
        this(name, eat);
        this.height = height;
        this.width = width;
        this.length = length;
    }

    //переопределение метода класса Object
    public String toString() {
        return String.format("%s его габариты (%d;%d;%d) ", name, height, width, length);
    }

    //переопределение метода класса Animal
    public String eating() {
        return "Он ест.";
    }
}
