package src;

import java.util.Dictionary;
import java.util.Hashtable;

public class dictCheck {
    public static void main(String[] args) {

        int id = 20;
        Dictionary dict = new Hashtable();
        dict.put(id, "Hello");
        System.out.println(dict.get(id));
    }
}
