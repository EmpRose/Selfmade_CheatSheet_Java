package Streams.Map;

import java.util.*;
// Erhaltene Elemente können von einem Datentyp in einen anderen Datentyp eingespeichert werden.
// array -> toArray()
// list -> collect(Collectors.toList())
// set -> collect(Collectors.toSet())
public class StreamExampleMap {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("privet");
        list.add("kak dela?");
        list.add("OK");
        list.add("poka");


        //For-Loop: Wir ersetzen die Strings in der Liste mit Integern (Länger der Strings)
        /*
        for(int i = 0; i<list.size();i++){
            list.set(i, String.valueOf(list.get(i).length()));
        }
        System.out.println(list);
         */

        //Stream:
        /*
        // Stream: Wir arbeiten nicht direkt mit der Liste, sondern erstellen Streams für die Verarbeitung
        // element == String aus der Liste
        // Map: Stellt zu jedem Element des Streams, das resultat der Rückgabe (aus dem Rückgabestream)
        // collect: Formatiert die Rückgabewerte in einer Liste .

        // .stream() erstellt ein Stream mit Inhalten einer Liste anhand einer Liste, .map() gibt einen Rückgabestream mit verarbeiteten
        // Elementen zurück die in zum Beispiel einer Liste durch "collect" eingespeichert werden können.
        List<Integer> list2 = list.stream().collection.map(element -> element.length()).collect(Collectors.toList());
        System.out.println(list2);
         */

        // Map auf Array
        /*
        int[] array = {5, 9, 3, 8, 1};
        array = Arrays.stream(array).collection.map(element
                -> {if(element%3==0){
                    element = element/3;
                }
                return element;
        }).toArray();
        System.out.println(Arrays.toString(array));
        */

        // Map auf collection.Set -> List
        /*
        collection.Set<String> set = new TreeSet<>();
        set.add("privet");
        set.add("kak dela?");
        set.add("OK");
        set.add("poka");

        System.out.println(set);

        collection.Set<Integer> set2 = set.stream().collection.map(element -> element.length()).collect(Collectors.toSet());
        List<Integer> list3 = set.stream().collection.map(element -> element.length()).collect(Collectors.toList());
        System.out.println(list3);
        */

}
}

