package Multithreading.ThreadSafeMultithreadCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SynchronizedCollectionExample2 {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i < 1001; i++) {
            arrayList.add(i);
        }

        // Erstellung einer synchronisierten Liste
        List<Integer> synchList = Collections.synchronizedList(arrayList);

        // Sicherstellen der Synchronisierung beim Iterieren
        Runnable runnable = () -> {
            synchronized (synchList) {
                Iterator<Integer> iterator = synchList.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
            }
        };

        // Entfernen eines Elements in einem separaten Thread
        Runnable runnable2 = () -> {
            synchList.remove(9);
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(synchList);
    }
}