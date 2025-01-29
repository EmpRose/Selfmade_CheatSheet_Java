package Multithreading.ThreadSafeMultithreadCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedCollectionExample1 {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> source = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            source.add(i);
        }

        //ArrayList<Integer> targed = new ArrayList<>();
        List<Integer> synchList = Collections.synchronizedList(new ArrayList<>());
        Runnable runnable = () -> {
            synchList.addAll(source);
        };

        // Bei synchronisierter Arbeit ->
        // Sobald ein Thread mit der Ausführung des Tasks beginnt, wird der Zugang für andere Threads blockiert.
        // Nach der Erfüllung des Tasks, ist der Zugang wieder offen und ein anderer Thread kann mit seiner Arbeit beginnen.
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        // Ohne Synchronisierung ->
        // Durch das einfügen der Werte mit mehreren Threads ist das Resultat nicht vorhersehbar
        //System.out.println(targed);

        // Mit synchronizierung ->
        // Das Einfügen der Werte ist nun synchroniziert und das Resultat ist vorhersehbar
        System.out.println(synchList);
    }
}
