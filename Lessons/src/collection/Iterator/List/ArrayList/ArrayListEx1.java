package collection.Iterator.List.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx1 {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<String>(); // Beim erstellen von ArrayList, wird ein Array vom Typ Object mit 10 Positionen erstellt.
                                                                // Wenn, die Menge an Input die 10 Positionen übersteigt, wird ein neues Array erstellt, mit zusätzlichen Plätzen, mit weiteren 10 Positionen.
                                                                // new ArrayList<>(30) <- auf diese Weise, geben wir im Vorfeld an, wie viele Plätze notwendig sind.
        arrayList1.add("Zaur");
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");
        System.out.println(arrayList1);

        ArrayList<String> arrayList2 = new ArrayList<>(20);
        arrayList2.add("Zaur");
        arrayList2.add("Ivan");



        ArrayList<String> arrayList4 = new ArrayList<>(arrayList1); // ArrayList 4 ist ein neues Objekt, dass nicht auf ArList1 verweist.
        System.out.println(arrayList4);
        System.out.println(arrayList1==arrayList4);                 // gleicher Inhalt, verschiedene Objekte: Output - false

        // Wenn bei der Deklaration einer ArrayList kein Generic (Datentyp) angegeben wird,
        // prüft der Compiler nicht, welche Werte eingetragen werden und lässt alle zu. (Object, String, int, usw.)
        // Dies sollte jedoch nicht gemacht werden, da es zu Fehlern führen kann und wird.



    }

}
