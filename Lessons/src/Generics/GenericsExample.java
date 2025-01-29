package Generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsExample {
    public static void main(String[] args) {

        // raw-type - ohne <> (diamond)
        //Keine gute Praktik
        //List list = new ArrayList();
        //list.add("OK");
        //list.add(5);
        //list.add(new StringBulder("Hello"));
        //list.add(new Vehicle());


        List<String> list = new ArrayList<>();
        list.add("privet");
        list.add("poka");
        list.add("ok");
        list.add("random symbols");

        // Wenn wir keine Parameter für die Liste angeben, müssen wir auf "Object" zugreifen.
        for (Object o : list){
            System.out.println(o +  ": symbol length = " + ((String)o).length());
        }
    }
}
