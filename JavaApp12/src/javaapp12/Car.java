package javaapp12;

/**
 * Created by Губин_Н on 13.05.2016.
 */
public class Car {

    private String model;
    private String make;

    public Car( String make,String model) {
        this.model = model;
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
