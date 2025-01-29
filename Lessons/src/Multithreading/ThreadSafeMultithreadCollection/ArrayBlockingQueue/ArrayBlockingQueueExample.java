package Multithreading.ThreadSafeMultithreadCollection.ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

//capacity restrited ! (Das Array hat eine feste größe)
public class ArrayBlockingQueueExample {

    public static void main(String[] args) {
                                                                            // Angabe der Größe ist obvivalent
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        // Exception erfolgt, da kein Platz mehr vorhanden "Queue full"
        //queue.add(6);

        // mit .offer() wird "versucht" ein Element hinzugefügt zu werden -> es erfolgt keine Exception, wenn dies nicht möglich ist
        queue.offer(6);

        System.out.println(queue);
    }
}
