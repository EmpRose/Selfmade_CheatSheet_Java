package collection.Iterator.List.ArrayList;

import java.util.ArrayList;

public class ArrayListMethods1 {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<String>();
        arrayList1.add("Zaur");                                 // .add - fügt ein Element hinzu
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");

        arrayList1.add(1, "Misha");                // .add(index,element) fügt ein Element an einer bestimmten Stelle hinzu,
        // andere Elemente werden verschoben (+1)
        // Das Hinzufügen an ein nicht existierenden Index, ist nicht möglich
        for (String s : arrayList1) {
            System.out.println(s + " ");
        }
        System.out.println("_____________________________________");

        //ArrayList<Integer> arrayList2 = new ArrayList<Integer>(); // ArrayList benötigt Wrap-Klassen für primitive Datentypen
        // ArrayList<int> ist falsch!

        for (int i = 0; i < arrayList1.size(); i++) {               // .size gibt an wie lang ein Array ist.
            System.out.println(arrayList1.get(i));                  // .get gibt den Inhalt des eingegebenen Indexes an.
        }
        System.out.println("_____________________________________");

        arrayList1.set(0,"Matvej");                                 // .set fügt Element hinzu und ersetzt , falls vorhanden, das bestehende Element
        System.out.println(arrayList1);
        System.out.println("_____________________________________");

        arrayList1.remove(0);                                   // .remove löscht Element an Index Position
        System.out.println(arrayList1);                             // Index für alle Elemente nach gelöschtem Element (-1)
        System.out.println("_____________________________________");




    }
}
