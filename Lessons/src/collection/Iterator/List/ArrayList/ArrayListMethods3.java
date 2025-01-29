package collection.Iterator.List.ArrayList;

import java.util.ArrayList;

public class ArrayListMethods3 {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<String>();
        arrayList1.add("Zaur");                                 // .add - fügt ein Element hinzu
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");
        arrayList1.add("Ivan");

        System.out.println(arrayList1);                         //[Zaur, Ivan, Mariya]
        System.out.println("_______________________________________");

        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("!!!");
        arrayList2.add("???");
        System.out.println(arrayList2);                          //[!!!, ???]
        System.out.println("_______________________________________");

        //arrayList1.addAll(arrayList2);                          // .addAll fügt alle Elemente einer Liste an das ende der angegebenen Liste
        //System.out.println(arrayList1);                         //[Zaur, Ivan, Mariya, !!!, ???]
        //System.out.println("_______________________________________");

        arrayList1.addAll(1,arrayList2);                    // .addAll(index,List) fügt alle Elemente einer Liste an die Position der angegeenen Liste.
                                                                  // Elemente der angegebenen Liste, werden nach hinten umgestellt.
        System.out.println(arrayList1);                           //[Zaur, !!!, ???, Ivan, Mariya]
        System.out.println("_______________________________________");

        arrayList2.clear();                                         // .clear entfernt alle Elemente der Liste
        System.out.println(arrayList2);                             // []
        System.out.println("_______________________________________");

        System.out.println(arrayList1.indexOf("Mariya"));           // .indexOf gibt Index des ersten gesuchten Elementes/ Objekts aus.
        System.out.println("_______________________________________");

        System.out.println(arrayList1.lastIndexOf("Ivan"));      // .lastIndexOf gibt Index des letzten gesuchten Elementes / Objektes aus.
        System.out.println("_______________________________________");

        System.out.println(arrayList1.size());                      // .size gibt die Länge des Arrays aus
        System.out.println("_______________________________________");

        System.out.println(arrayList1.isEmpty());                   // .isEmpty gibt True/False zurück. Prüft ob Liste leer ist.
        //arrayList1.clear();
        System.out.println("_______________________________________");

        System.out.println(arrayList1.contains("Kolya"));           // .contains True/False Prüft ob das Gesuchte Element existiert / beinhaltet wird
        System.out.println("_______________________________________");

        System.out.println(arrayList1.toString());                  // .toString muss nicht angegeben werden, da automatisch vorhanden.
        System.out.println("_______________________________________");
    }
}
