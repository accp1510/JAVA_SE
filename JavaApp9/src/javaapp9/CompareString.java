package javaapp9;

import java.util.Comparator;

/**
 * Created by Губин_Н on 04.05.2016.
 */
public class CompareString implements Comparator {

    public int compare(Object o, Object t1) {
        String s1 = (String) o;
        String s2 = (String) t1;
        if (s1.length() == s2.length()) return s1.compareTo(s2);
        return s1.length() - s2.length();
    }
}
