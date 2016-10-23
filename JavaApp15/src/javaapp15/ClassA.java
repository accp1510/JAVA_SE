package javaapp15;


//применение собственной аннотации к классу
@MethInfo(name = "Петр", date = "20/05/2016", version = 10)
public class ClassA {

    @Deprecated
    //применение собственной аннотации к методу
    @MethInfo(name = "Петр", date = "20/05/2016", version = 1)
    public void method(String s) {
        System.out.println("Бызовый класс");
    }

    @MethInfo(name = "Петр", date = "21/05/2016", version = 10)
    public void method1(String s) {
        System.out.println("Бызовый класс");
    }

    private void method2(String s) {
        System.out.println("Бызовый класс");
    }
}
