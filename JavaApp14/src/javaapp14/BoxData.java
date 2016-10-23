package javaapp14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//T - универсальный тип
public class BoxData<T> {

    private List<T> dataList = new ArrayList<T>();

    public void add(T o) {
        dataList.add(o);
    }

    public void print() {
        Iterator<T> it = dataList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public T item(int i) {
        return (T) dataList.get(i);
    }

}
