package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQueueExample {
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();

        // .add(key) Fügt Elemente hinzu, sofern die "Schlange" noch Kapazitäten hat
        q.add("Zaur");
        q.add("Oleg");
        q.add("Ivan");
        // Wenn die Schlange zum Hinzufügen voll ist, entspringt keine Fehlermeldung, bei der nutzung von .offer
        q.offer("Mariya");
        q.offer("Aleksandr");

        System.out.println(q);
    }
}
