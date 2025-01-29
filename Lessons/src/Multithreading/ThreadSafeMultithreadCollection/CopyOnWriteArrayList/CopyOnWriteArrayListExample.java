package Multithreading.ThreadSafeMultithreadCollection.CopyOnWriteArrayList;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {

    public static void main(String[] args) throws InterruptedException {
        //CopyOnWriteArraySet existiert und funktioniert ähnlich.
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Zaur");
        list.add("Oleg");
        list.add("Sergey");
        list.add("Ivan");
        list.add("Egor");

        System.out.println(list);

        Runnable runnable1 = () -> {
            // Vor dem iterieren der Kollektion, wurde eine Kopie der Kollektion für die iteration erstellt.
            Iterator<String> iterator = list.iterator();
            while(iterator.hasNext()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(iterator.next());
            }
        };

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list.remove(4);
            list.add("Elena");
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(list);
    }
}
