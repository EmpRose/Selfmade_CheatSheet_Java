package Multithreading.AtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;
/*
AtomicInteger ist eine Klasse, die es ermöglicht mit ganzzahligen Werten von Int mit atomaren Operatinen zu arbeiten.
Data Race tritt auf diesem Weg nicht auf.

.incrementAndGet()
.getAndIncrement()
.addAndGet()
.getAndAdd()
.decrementAndGet()
.getAndDecrement()

 */
public class AtomicIntegerExample {
//static int counter = 0;
    static AtomicInteger counter = new AtomicInteger(); // Parameter by default = 0

// Data Race, wenn ohne "synchronized" -> Ergebnis ist nicht immer eindeutig (Ohne AtomicInteger)
public  static void increment(){
    //counter++;
    //counter.incrementAndGet(); // erhöhe und gebe zurück
    counter.addAndGet(5); // 5 -> Wert um den erhöht wird (auch -5)
}
    public static void main(String[] args) throws InterruptedException {
    Thread thread1 = new Thread(new myRunnableImpl());
    Thread thread2 = new Thread(new myRunnableImpl());

    thread1.start();
    thread2.start();

    thread1.join();
    thread2.join();

        System.out.println(counter);
    }
}


class myRunnableImpl implements Runnable{
    public void run(){
        for (int i = 0; i < 100; i++){
            AtomicIntegerExample.increment();
        }
    }
}