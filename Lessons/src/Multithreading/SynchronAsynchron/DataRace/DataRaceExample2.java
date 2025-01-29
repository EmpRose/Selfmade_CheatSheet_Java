package Multithreading.SynchronAsynchron.DataRace;
/*
Data Race -> ist ein "Problem",
welches erfolgen kann, wenn zwei und mehr Threads sich an eine
Variable wenden und mindestens ein Thread die Variable verändert.
 */

// Synchronized Beispiel: public synchronized void abc(){ method body }

public class DataRaceExample2 {
    // Variablen können "volatile" sein, aber nicht "synchronized
    static int counter = 0;
    // synchronized -> Sorgt dafür, dass immer nur ein Thread ausgeführt wird. Andere Warten, bis er fertig ist.
    public static synchronized void increment(){counter++;}

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new R());
        Thread thread2 = new Thread(new R());


        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        // Ausgabe erwartet: 200 -> Doch dafür gibt es keine Garantie, da die Threads nicht synchron laufen.
        // synchronized Aufruf von increment -> sorgt für synchrone Verarbeitung und das richtige Ergebnis.
        System.out.println(counter);




    }


}

class R implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++){
            DataRaceExample2.increment();
        }
    }
}
