package collection.Map.HashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample1 {
    public static void main(String[] args) {
        // Key: Integer / Wert : String
        // Der Key muss unique sein
        Map<Integer,String> map1 = new HashMap<>();

        // .put anstelle von .add zum Hinzufügen
        // Jedes Element ist ein Paar vom Key und Wert
        // Key und Wert können "null" sein
        map1.put(1000,"Zaur Tregulov");
        map1.put(3568,"Ivan Ivanov");
        map1.put(6578,"Mariya Sidorova");
        map1.put(98745,"Nikolay Petrov");
        map1.put(15879,"Nikolay Petrov");

        // Bei einer nutzung des selbigen Keys, wird der bestehende Wert unter dem Key ersetzt
        map1.put(1000,"Oleg Ivanov");
        map1.put(null,"Sergey Petrov");
        map1.put(85214,null);
        // Die Speicherreinfolge wird nicht berütcksichtigt, da diese nicht "gemerkt" wird
        System.out.println(map1);
        System.out.println("________________");

        // .putIfAbsent fügt ein Element nur hinzu, wenn der Key-Wert nicht existiert
        map1.putIfAbsent(1000,"Zaur Tregulov");
        System.out.println(map1);
        System.out.println("________________");

        // .get Zeigt Element anhand seines Keys an - "null" Wenn Key nicht existiert
        System.out.println(map1.get(1000));
        System.out.println("________________");

        // .remove Löscht ein Element anhand seines Keys
        map1.remove(15879);
        System.out.println(map1);
        System.out.println("________________");

        // .containsValue (.containsKey) Gibt True/False zurück, wenn das gesuchte Element existiert/nicht existiert
        System.out.println(map1.containsValue("Ivan Ivanov"));
        System.out.println("________________");

        // .keySet Gibt die KeySets der Keys zurück (Gibt alle existierenden Keys zurück)
        System.out.println(map1.keySet());
        System.out.println("________________");

        // .values Gibt die Werte des Hashmaps als ValueSet zurück
        System.out.println(map1.values());
        System.out.println("________________");

        // .entrySet Gibt einen "Satz" der Elemente einer HashMap zurück
        System.out.println(map1.entrySet());
        System.out.println("________________");

        // Keys und Werte können verschiedene und identische Datentypen haben.
        Map<String, String> map2 = new HashMap<>();
        map2.put("Sascha","Dobriy");
        map2.put("Mischa","Umniy");
        System.out.println(map2);
        System.out.println("________________");
    }
}
