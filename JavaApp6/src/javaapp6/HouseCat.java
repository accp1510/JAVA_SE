package javaapp6;

//класс-потомок
public class HouseCat extends Cat {
    //поле потомка
    public String placeHouse;

    //переопределение метода. замена реализациии базового метода базового класса
    public void live() {
        System.out.println("Он живет в доме. Любимое место " + placeHouse);
    }

    public HouseCat(String name,String eat, String placeHouse) {
        //вызов конструктора базового класса Cat
        super(name,eat);
        this.placeHouse = placeHouse;
    }

    //перегрузка метода. Одно имя, другое количество и тип аргуметов
    public void live(int i) {
        if (i > 0)
            for (int j = 0; j < i; j++) {
                //i-раз вызывается метод базового класса
                super.live();
            }
    }

    //переопределение метода класса Cat
    public String eating() {
        return "Ест, что дадут.";
    }


}
