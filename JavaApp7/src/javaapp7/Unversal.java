package javaapp7;

/**
 * Created by Губин_Н on 27.04.2016.
 */
public class Unversal extends Car {
    private float maxSpeed;

    public Unversal(String make, String model) {
        super(make, model);
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public void drive(float speed, float time) {
        super.drive(speed, time);
        maxSpeed = maxSpeed < speed ? speed : maxSpeed;
    }
}
