package Multithreading.SynchronAsynchron.DataRace;

public class DataRaceExample {
/*
Data Race -> ist ein "Problem",
welches erfolgen kann, wenn zwei und mehr Threads sich an eine
Variable wenden und mindestens ein Thread die Variable verändert.
 */


    public static void main(String[] args) {
        MyRunnableImplementation runnable = new MyRunnableImplementation();

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

class MyRunnableImplementation implements Runnable {
    public void increment() {
        Counter.count++;
        System.out.print(Counter.count + " ");
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++)
        {
            increment();
        }
    }
}