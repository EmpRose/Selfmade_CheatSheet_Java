package Multithreading.SynchronAsynchron.Monitor;

// Beim telefonieren, müssen andere Anrufer:innen warten, bis sie uns erreichen können. (Das Gespräch beendet wird)
public class MonitorObjectExample {
    // synchronized bezieht sich auf das Object "busy".
    // solange die Klasse in Verarbeitung einer Methode ist, kann sie keine anderen Methoden ausführen.
    // Da jedes Thread mit diesem Object arbeitet -> Die Reihenfolge hängt von der geschwindigkeit der Threads ab.
    static final Busy busy = new Busy();

    // für gewöhnlich wird keine Extra generierte Klasse genutzt, sondern direkt eine Klasse von Object erzeugt.
    // static final Object lock = new Object();
    // public void abc() {
    // synchronized(lock){ block body }
    // }

    // Ausnahme: Ein Constructor kann nicht synchronisierd werden.


    void mobileCall() {
        synchronized (busy) {
            System.out.println("Mobile call starts.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Mobile call ends.");
        }
    }

    synchronized void skypeCall() {
        synchronized (busy) {
            System.out.println("Skype call starts.");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Skype call ends.");
        }
    }

    synchronized void whatsAppCall() {
        synchronized (busy) {
            System.out.println("WhatsApp call starts.");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("WhatsApp call ends.");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableImlMobbile());
        Thread thread2 = new Thread(new RunnableImlSkype());
        Thread thread3 = new Thread(new RunnableImlWhatsApp());


        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class RunnableImlMobbile implements Runnable {
    public void run() {
        new MonitorObjectExample().mobileCall();
    }
}

class RunnableImlSkype implements Runnable {
    public void run() {
        new MonitorObjectExample().skypeCall();
    }
}

class RunnableImlWhatsApp implements Runnable {
    public void run() {
        new MonitorObjectExample().whatsAppCall();
    }
}

// Klasse für das Synchronized Object
class Busy {
}