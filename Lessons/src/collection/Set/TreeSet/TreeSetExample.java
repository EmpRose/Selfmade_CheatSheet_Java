package collection.Set.TreeSet;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();

        set.add(5);
        set.add(8);
        set.add(2);
        set.add(1);
        set.add(10);
        //Darf nicht null sein
        //set.add(null);

        // Elemente werden sortiert (aufsteigend) ausgegeben
        System.out.println(set);


        // Methoden des Interfaces "Collections"
        // .add
        // .remove
        // .size
        // .isEmpty
        // .contains
        // .get - hat keinen Sinn, da kein Wert, nur Key (gibt es nicht)

    }
}
