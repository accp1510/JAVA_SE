package javaapp6;

//второй потомок класса Cat
public class WildCat extends Cat {

    //поле потомка
    public String name;

    public WildCat(String name,String eat) {
        //вызов конструктора родителя
        super(name, eat, 50, 30, 100);
        //обращение к полю потомка public String name;
        this.name = name;
    }

    //просто метод
    public void catchAnimal() {
        System.out.println("Ловит травоядных");
    }

    //переопределение метода класса Cat
    public String eating() {
        return "Ест, что поймает.";
    }


}
