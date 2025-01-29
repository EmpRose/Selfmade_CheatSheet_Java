package Multithreading.ThreadSafeMultithreadCollection.ConcurrentHashMap;
// implementiert das Interface ConcurrentMap das vom Interface Map abstand
/*
ConcurrentHashMap ist eine threadsichere Implementierung der ConcurrentMap, die eine beliebige Anzahl von Leseoperationen ohne Sperren ermöglicht.
Wichtige Konzepte:
	•	Segmentierung:
	•	Die Daten werden in mehrere Segmente aufgeteilt (standardmäßig 16).
	•	Mehrere Threads können gleichzeitig auf verschiedene Segmente zugreifen und diese ändern.
	•	Innerhalb eines Segments ist jedoch gleichzeitiges Schreiben nicht möglich.
	•	Locking:
	•	Beim Schreiben wird nur das betroffene Segment gesperrt (Segment Locking/Bucket Locking), wodurch andere Segmente parallel bearbeitet werden können.
	•	Dadurch wird die Performance verbessert, im Vergleich zu einer vollständig synchronisierten HashMap.
Fazit:
Ideal für Anwendungen mit häufigen Lesezugriffen und gelegentlichen Schreiboperationen, bei denen hohe Parallelität erforderlich ist.
 */
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
public class ConcurrentHashMapExample {

    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<Integer,String> map = new ConcurrentHashMap<>();
        map.put(1,"Zaur");
        map.put(2,"Oleg");
        map.put(3,"Sergey");
        map.put(4,"Ivan");
        map.put(5,"Egor");

        System.out.println(map);

        Runnable runnable1 = () -> {
            Iterator<Integer> iterator = map.keySet().iterator();
            while (iterator.hasNext()){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Integer i = iterator.next();
                System.out.println(i + " : " + map.get(i));
            }
        };

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            map.put(6,"Elena");
        };
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(map);
    }
}
