package Multithreading.SynchronAsynchron.LockReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//.tryLock(); ->
// ermöglicht den Lock zu setzen für einen Thread, wenn die Reccourse verfügbar ist
// oder stattdessen etwas anderes auszuführen
public class LockExample2 {


    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Employee("Zaur", lock);
        new Employee("Oleg", lock);
        new Employee("Elena", lock);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Employee("Victor", lock);
        new Employee("Marina", lock);

    }
}


class Employee extends Thread {
    String name;
    private Lock lock;

    public Employee(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start();
    }

    public void run() {
        if (lock.tryLock()) {
            try {
                //System.out.println(name + " is waiting....");
                //lock.lock();
                System.out.println(name + " use the Bank.");
                Thread.sleep(2000);
                System.out.println(name + " finished.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(name + " dont want to wait.");
        }


    }
}