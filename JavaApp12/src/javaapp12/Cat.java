package javaapp12;


public class Cat {
    private String name;
    private boolean drive;

    public Cat(String name, boolean drive) {
        this.drive = drive;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDrive() {
        return drive;
    }

    public void setDrive(boolean drive) {
        this.drive = drive;
    }
}
