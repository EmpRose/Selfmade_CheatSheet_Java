package collection.Map.TreeMap;

import Klassen.Student3;

import java.util.TreeMap;

public class TreeMapExample2 {
    public static void main(String[] args) {
        TreeMap<Student3, Double> treeMap = new TreeMap<>();

        Student3 st1 = new Student3("Zaur", "Tregulov", 3);
        Student3 st2 = new Student3("Mariya", "Ivanova", 1);
        Student3 st3 = new Student3("Sergey", "Petrov", 4);
        Student3 st4 = new Student3("Igor", "Sidorov", 2);
        Student3 st5 = new Student3("Vasiliy", "Smirnov", 1);
        Student3 st6 = new Student3("Sasha", "Kapustin", 3);
        Student3 st7 = new Student3("Elena", "Sidorova", 4);
        Student3 st8 = new Student3("Elena", "Sidorova", 4);

        treeMap.put(st1,5.8);
        treeMap.put(st2,8.2);
        treeMap.put(st3,9.1);
        treeMap.put(st4,7.5);
        treeMap.put(st5,7.9);
        treeMap.put(st6,6.4);
        treeMap.put(st7,7.2);

        // Ohne der Implementierung von "Comparable" in der Klasse "Student3", erfolgt eine Fehlermeldung
        // Da für die Sortierung "Key" genutzt wird, müssen diese Keys geordnet werden können
        System.out.println(treeMap);

        System.out.println();
        System.out.println(treeMap.containsKey(st8));
        System.out.println();
        System.out.println(treeMap.containsValue("Zaur"));
    }
}
