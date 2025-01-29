package collection.Iterator.List.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMethods5 {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<String>();
        arrayList1.add("Zaur");
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");
        arrayList1.add("Kolya");
        arrayList1.add("Elena");

        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("Kolya");
        arrayList2.add("Mariya");
        //arrayList2.add("Igor");

        //arrayList1.removeAll(arrayList2);                         // .removeAll Entfernt alle identischen Einträge der Liste 2 aus Liste 1 (Mariya, Kolya)
        //System.out.println(arrayList1); //[Zaur, Ivan]
        //System.out.println("_______________________________________");

        //arrayList1.retainAll(arrayList2);                           // .retainAll Entfernt alle nicht identischen Einträge der Liste 2 aus Liste 1
        //System.out.println(arrayList1);
        //System.out.println("_______________________________________");

        //boolean result = arrayList1.containsAll(arrayList2);            // .containsAll Prüft ob Alle Elemente der Liste 2 in Liste 1 enthalten sind
        //System.out.println(result);
        //System.out.println("_______________________________________");

        List<String> myList = arrayList1.subList(1,4);                  // .subList (index start, index end (not includet)
        System.out.println(myList);                                     // Erstellt eine Liste aus den angegebenen Index Positionen einer anderen Liste (von - bis)
        System.out.println("_______________________________________");

        // myList ist ein View der arrayList1, die Liste existiert nicht selbstständig, sondern greift auf arrayList1 zu.
        myList.add("Fedor");
        System.out.println(myList + "\n" + arrayList1);
        // Das Element "Fedor" wird auch arrayList1 hinzugefügt
        System.out.println("_______________________________________");

        // Die Modifikation der Struktur, muss über das View erfolgen.
        //arrayList1.add("Sveta");
        //System.out.println(myList + "\n" + arrayList1);
        //System.out.println("_______________________________________");

        //Object[] array = arrayList1.toArray();
        //String[] array2 = arrayList1.toArray(new String[7]);          // Leerer index, wird als "null" ausgegeben.
                                                                        // mit new String [0], werden alle nicht angegebenen Index Positionen , automatisch zugefügt
        //for(String s: array2){
        //    System.out.println(s);
        //}

        // Statische Listen können weder modifiziert werden, noch dürgfen sie "NULL" beinhalten.

        List<Integer> list1 = List.of(3,8,13);                          // .listOf Erstellt fix eine statische Liste
        System.out.println(list1);
        //list1.add(100);                                               eine statische Liste, kann nicht modifiziert werden
        System.out.println("_______________________________________");

        List<String> list2 = List.copyOf(arrayList1);                   // .copyOf Kopiert eine existierende Liste in eine statische neue Liste
        System.out.println(list2);
        System.out.println("_______________________________________");
    }
}
