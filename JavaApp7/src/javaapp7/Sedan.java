package javaapp7;

public class Sedan extends Car {
    private float distance;

    public Sedan(String make, String model) {
        super(make, model);
    }

    public float getDistance() {
        return distance;
    }

    public void drive(float speed, float time) {
        super.drive(speed, time);
        distance+=speed*time;
    }
}
