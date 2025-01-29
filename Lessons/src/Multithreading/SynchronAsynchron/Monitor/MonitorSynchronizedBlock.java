package Multithreading.SynchronAsynchron.Monitor;

public class MonitorSynchronizedBlock {
    static int counter = 0;

    // Synchronize ist nur auf Code-Blöcken anwendbar, wenn die Methode nicht "statisch" ist.
    // Sonnst wird der Monitor der gesammten Klasse genutzt.
    public static synchronized void increment() {
        // Bei der Nutzung von Synchronized Block, müssen wir unsere Klasse angeben -> für zBsp "reflection" angewandt
        //synchronized(MonitorSynchronizedBlock.class){}
        counter++;
    }


    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class Counter {
    volatile static int count = 0;
}

class MyRunnable implements Runnable {
    private void doWork2(){
        System.out.println("Ura!");
    }

    /*
    Je nach dem, ob die Methode oder nur ein einzelner Code-Block synchronisiert verarbeitet werden muss,
    können wir "synchronized" entsprechend einsetzen.
     */
    private void doWork1() {
        // Code-Block -> nicht synchronisiert.
        doWork2();
        // synchronized (Object/Class). Anstelle der ganzen Methode, erfolgt nun nur die Ausführung bestimmten Codeblocks synchron.
        // this -> das aktuelle Object, was den Code verarbeitet. (Sollte auch so klar sein..:))
        synchronized (this) {
            Counter.count++;
            System.out.println(Counter.count);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            doWork1();
        }
    }
}