package Queue;

import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(4);
        pq.add(1);
        pq.add(7);
        pq.add(10);
        pq.add(8);

        // Bei der einfachen Ausgabe, wird die aufsteigende Reihenfolge nicht eingehalten, dafür bei der Nutzung der Elemente
        System.out.println(pq);
        // Die natürliche Reihenfolge ist Aufsteigend (klein zu groß)
        System.out.println(pq.peek());


    }
}
