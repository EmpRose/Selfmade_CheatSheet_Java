package Generics.Wildcards;

import java.util.ArrayList;
import java.util.List;

public class WildcardsExample {
    public static void main(String[] args) {
        // Symbol für Wildcard (?) -> ? == superType für jede Liste
        List<?> list = new ArrayList<Integer>();
        List<Double> list1 = new ArrayList<>();
        list1.add(3.14);
        list1.add(3.15);
        list1.add(3.16);

        showListInfo(list1);

        System.out.println();
        List<String> list2 = new ArrayList<>();
        list2.add("privet");
        list2.add("poka");
        list2.add("ok");

        showListInfo(list2);

        System.out.println();
        ArrayList<Double> ald = new ArrayList<>();
        ald.add(3.14);
        ald.add(3.15);
        ald.add(3.16);
        System.out.println(summ(ald));

        // Unter der Nutzung von WIldcat-Parameter,
        // ist die Nutzung von Methoden, die das Objekt verändern "Nicht Möglich!"
        // List<?> list3 = new ArrayList<String>();
        // list.add();
        List<? super Number> list3 = new ArrayList<>();
        list3.add(15);

    }
    // Die Methode "summ", kann nur von ArrayListen des Datentyps "Number" oder desen Erben sein. (Integer, Float,Double,Long usw..)
    static double summ(ArrayList<? extends Number> al){
        double summ=0;
        for(Number n:al){
            summ+=n.doubleValue();
        }
        return summ;
    }

    static void showListInfo(List<?> list){
        System.out.println("List contains elements of: " + list);
    }
}
