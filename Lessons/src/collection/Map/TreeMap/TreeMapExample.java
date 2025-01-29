package collection.Map.TreeMap;

import Klassen.Student3;


import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Double, Student3> treeMap = new TreeMap<>();

        Student3 st1 = new Student3("Zaur", "Tregulov", 3);
        Student3 st2 = new Student3("Mariya", "Ivanova", 1);
        Student3 st3 = new Student3("Sergey", "Petrov", 4);
        Student3 st4 = new Student3("Igor", "Sidorov", 2);
        Student3 st5 = new Student3("Vasiliy", "Smirnov", 1);
        Student3 st6 = new Student3("Sasha", "Kapustin", 3);
        Student3 st7 = new Student3("Elena", "Sidorova", 4);

        // .put
        // Die Elemente werden nach den Keys sortiert, dass heißt, das der Key-Wert comparable sein muss
        // Wenn wir eine Klasse als Key angeben, muss die Klasse Comparable implementieren
        // Entweder in der Klasse selbst oder bei der Implementierung von TreeMap
        treeMap.put(5.8, st1);
        treeMap.put(8.2, st6);
        treeMap.put(9.1, st7);
        treeMap.put(7.5, st4);
        treeMap.put(7.9, st5);
        treeMap.put(6.4, st2);
        treeMap.put(7.2, st3);

        // Die Keys müssen unique sein, sonnst wir das Element überschrieben. Auch bei verschiedenen Values
        // treeMap.put(7.2, st4); - überschreibt st3

        // Im Vergleich zu HashMap, werden die Elemente nach Key aufsteigend sortiert/ gespeichert.
        System.out.println(treeMap);
        System.out.println("________________________________");

        //.get
        System.out.println(treeMap.get(6.4));
        System.out.println("________________________________");
        //.remove
        treeMap.remove(5.8);
        System.out.println(treeMap);
        System.out.println("________________________________");

        // .decendingMap - Gibt das collection.map.TreeMap absteigend anhand der Keys zurück
        System.out.println(treeMap.descendingMap());
        System.out.println("________________________________");

        // .tailMap - Gibt werte ab XX zurück
        System.out.println(treeMap.tailMap(7.3));
        System.out.println("________________________________");

        // .headMap gibt Werte bis XX zurück
        System.out.println(treeMap.headMap(7.3));
        System.out.println("________________________________");

        // .lastEntry Gibt den letzten Wert aus dem collection.map.TreeMap zurück
        System.out.println(treeMap.lastEntry());
        System.out.println("________________________________");

        // .firstEntry - Gibt den ersten Wert zurück
        System.out.println(treeMap.firstEntry());
        System.out.println("________________________________");

    }
}
