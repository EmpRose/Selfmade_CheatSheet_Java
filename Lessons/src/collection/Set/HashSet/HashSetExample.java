package collection.Set.HashSet;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        // Beim Aufruf von "add" , wird unter dem Deckel "put" von HashMap aufgerufen
        set.add("Zaur");
        set.add("Oleg");
        set.add("Marina");
        set.add("Igor");
        //HashSet kann keine Duplikate beinhalten - Wird nicht hinzugefügt
        set.add("Igor");

        // Die Reihenfolge ist nicht gespeichert
        System.out.println(set);

        //
        for (String s : set){
            System.out.println(s);
        }
        // Methoden des Interfaces "Collections"
        // .remove
        // .size
        // .isEmpty
        // .contains
        // .get - hat keinen Sinn, da kein Wert, nur Key (gibt es nicht)


        // collection.Set ist eine Mehrzahl
        Set<Integer> hset = new HashSet<>();
        hset.add(2);
        hset.add(3);
        hset.add(1);
        hset.add(5);
        hset.add(8);

        Set<Integer> hset2 = new HashSet<>();
        hset2.add(7);
        hset2.add(4);
        hset2.add(5);
        hset2.add(3);
        hset2.add(8);

        // Union 2,1,3,8,5,7,4 (3,8,5 werden nicht dubliert)

        Set<Integer> union = new HashSet<>(hset);
        union.addAll(hset2);
        System.out.println(union);

        // intersect Behält im ersten collection.Set nur die Elemente(Keys), die auch im zweiten collection.Set enthalten sind
        Set<Integer> intersect = new HashSet<>(hset);
        intersect.retainAll(hset2);
        System.out.println(intersect);

        // subtract - Entfernt aus dem ersten collection.Set, alle Elemente des zweiten Sets (Die im ersten vorhanden sind aber nicht im zweiten)
        Set<Integer> subtract = new HashSet<>(hset);
        subtract.removeAll(hset2);
        System.out.println(subtract);
    }
}
