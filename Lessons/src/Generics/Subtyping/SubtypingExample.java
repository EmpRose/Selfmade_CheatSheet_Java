package Generics.Subtyping;

import java.util.ArrayList;
import java.util.List;

public class SubtypingExample {
    public static void main(String[] args) {
        X x = new Y();

        /*
        List<Number> list = new ArrayList<Integer>();
        list.add(18);
        list.add(3.4);

        // Integer erbt aus Number, sowie Double auch.
        // Jedoch ist die ArrayList "Integer" und kann kein "Double" aufnehmen
        // Deshalb ist auch die Initialisierung so nicht korrekt.
        */
    }
}

class X{
}

class Y extends X{
}

