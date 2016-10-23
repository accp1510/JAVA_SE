package javaapp7;
//реализация интерфейса
public class Car implements CarListener {
    private String make;
    private String model;

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public void drive(float speed, float time) {
        System.out.println("Автомобиль проехал " + (speed * time) + " км");
    }

    //реализация метода интресейса
    public void print() {
        System.out.println(make + " " + model);
        //обращение к константе интерфейса
       // System.out.println(CarListener.field);
    }
}
