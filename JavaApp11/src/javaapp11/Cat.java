package javaapp11;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Губин_Н on 11.05.2016.
 */
public class Cat implements Serializable{
    private String name;
    private String color;
    private List<Cat> listCats;


    public Cat() {
        listCats = new ArrayList<Cat>();
    }

    public Cat(String name, String color) {
        this();
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", listCats=" + listCats +
                '}';
    }

    public void addCat(Cat cat) {
        listCats.add(cat);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Cat> getListCats() {
        return listCats;
    }

    public void setListCats(List<Cat> listCats) {
        this.listCats = listCats;
    }
}
