package collection.Iterator.List.Iterator;
import java.util.Iterator;
import java.util.ArrayList;

public class IteratorExample {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<String>();
        arrayList1.add("Zaur");
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");
        arrayList1.add("Kolya");
        arrayList1.add("Elena");

        Iterator<String> iterator = arrayList1.iterator();

        while(iterator.hasNext()){                      // .hastNext True, wenn es ein weiteres Element in der Liste gibt
            //System.out.println(iterator.next());      // .next bezieht sich auf den nächsten Index des Elements
            iterator.next();                            // .next Greift auf das  nächste Element "zu"
            iterator.remove();                          // .remove Löscht das Element, auf das "zugegriffen" wurde. (Ohne .next, kann nichts gelöscht werden)
        }
    }


}
