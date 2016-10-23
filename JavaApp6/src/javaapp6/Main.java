package javaapp6;

public class Main {

    public static void main(String[] args) {
        //родиетльская кошка
        Cat cat = new Cat();
        System.out.println(cat);
        System.out.println("Вызов обычного метода");
        cat.live();

        //наследник класса Cat
        HouseCat houseCat = new HouseCat("Васек","Колбаска", "Диван");
        System.out.println(houseCat);
        System.out.println();
        System.out.println("Вызов переопределенного метода");
        houseCat.live();
        houseCat.live(5);
        System.out.println();

        //наследник класса Cat
        WildCat wildCat = new WildCat("Тигр", "Газель");
        System.out.println(wildCat);
        wildCat.catchAnimal();

        //Невозможно создать объект абстрактного класса  Animal animal = new Animal();
        //Но можно использовать его методы
        System.out.println();
        cat.loveEating();
        houseCat.loveEating();
        wildCat.loveEating();
    }
}
