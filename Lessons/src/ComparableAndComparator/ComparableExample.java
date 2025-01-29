package ComparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Zaur");
        list.add("Matvej");
        list.add("Ivan");
        list.add("Elena");
        list.add("Petr");

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
