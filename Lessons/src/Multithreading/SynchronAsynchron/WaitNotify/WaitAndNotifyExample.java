package Multithreading.SynchronAsynchron.WaitNotify;
// .wait(); -
// "Befreit" den Monitor und setzt den aufrufenden Thread in den Wartemodus, bis eine andere Methode .notify() zurückgibt.
// .notify();-
// setzt den Monitor nicht "frei" und wekct den Thread, bei dem zuvor .notify(); ausgeführt wurde.
// .notifyAll(); -
// Befreit den Monitor nicht und weckt alle Threads, die zuvor mit .notify(); belegt waren.

// Beispiel:
/*
Auf einer Ladenfläche, wird Brot verkauft. Es passen maximal 5 Brotte auf die Vitrine.
Der Verkäufer kann erst neues Brot dazulegen, wenn er mindestens ein Brot zuvor verkauft.
Der Käufer kann kein Brot kaufen, solange keins in der Vitrine liegt.
 */
public class WaitAndNotifyExample {
    public static void main(String[] args) {
        Market market = new Market();
        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);

        // Auch hier ist die Reihenfolge nicht vorhersehbar. Der schnellere Thread übernimmt.
        thread1.start();
        thread2.start();
    }


}

class Market {
    private int breadCount = 0;
    private final Object lock = new Object();

    // lock Object Code-Block
    public  void getBread() {
        synchronized (lock) {
            while (breadCount < 1) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            breadCount--;
            System.out.println("Customer did buy bread.");
            System.out.println("Brot auf der Vitrine: " + breadCount);
            lock.notify();
        }
    }

    // Synchronized Method
    public synchronized void putBread() {
        while (breadCount >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        breadCount++;
        System.out.println("Bread was delivered.");
        System.out.println("Brot auf der Vitrine: " + breadCount);
        notify();
    }
}

class Producer implements Runnable {
    Market market;

    public Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.putBread();
        }
    }
}

class Consumer implements Runnable {
    Market market;

    public Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.getBread();
        }
    }
}