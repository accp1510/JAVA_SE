package javaapp6;

//абстрактный класс(частично реализованный)
public abstract class Animal {
    //доступно к классе Animal и в классе помоках
    protected String eat;

    //абстрактный метод
    public abstract String eating();

    //просто метод
    public void loveEating() {
        //вызов абтрактного метода
        String s = eating();
        System.out.println(s + " Но любит " + eat);
    }
}
