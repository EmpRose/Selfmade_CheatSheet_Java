package collection.LinkedHashMap;

import Klassen.Student3;

import java.util.LinkedHashMap;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        // accesOrder - Ist entscheident für die Reihenfolge der Verarbeitung/Ausgabe

        LinkedHashMap<Double, Student3> lhm = new LinkedHashMap<>(16,0.75f,true);

        Student3 st1 = new Student3("Zaur", "Tregulov", 3);
        Student3 st2 = new Student3("Mariya", "Ivanova", 1);
        Student3 st3 = new Student3("Sergey", "Petrov", 4);
        Student3 st4 = new Student3("Igor", "Sidorov", 2);


        // .put
        lhm.put(5.8, st1);
        lhm.put(8.2, st2);
        lhm.put(9.1, st3);
        lhm.put(7.5, st4);

        // Die Ausgabe entspricht der "put" Reihenfolge (accessOrder = false)
        System.out.println(lhm);
        System.out.println("___________________________");

        lhm.get(5.8);
        lhm.get(9.1);
        lhm.get(8.2);

        // Die Reihenfolge ändert sich, anhand der häufigkeit der Nutzung der Elemente (accessOrder = true)
        System.out.println(lhm);
        System.out.println("___________________________");
    }
}
