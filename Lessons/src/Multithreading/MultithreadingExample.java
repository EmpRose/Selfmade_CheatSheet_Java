package Multithreading;

public class MultithreadingExample {
    public static void main(String[] args) {

        // Jeweils ein Thread, automatisch ausgeführt. Instruktionen wurden der Reihe nach ausgeführt.
        /*
        System.out.println("Hello");

        for (int i = 0; i < 10; i++){
            System.out.println(i+1);
        }

        System.out.println("Bye!");

         */

        // (Drei mit main) Zwei Threads die parallel und gleichzeitig laufen. Keine Kontrolle darüber, welcher Thread, wann ausgeführt wird.
        // Threads arbeiten nicht synchronoziert
        /*
        MyThread1 mThread1 = new MyThread1();
        MyThread2 mThread2 = new MyThread2();

        // Durch .start(), wird die Methode .run() ausgeführt.
        mThread1.start();
        mThread2.start();
         */

        /*
        // Threads über Interface
        Thread thread3 = new Thread(new MyThread3());
        Thread thread4 = new Thread(new MyThread4());
        thread3.start();
        thread4.start();
         */

        // Thread erstellung mit anonymen Klassen
        /*
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hi, there!");
            }
        }).start();
         */

        // Thread mit einem Lambda Ausdruck
        /*
        new Thread(()-> System.out.println("Olla!")).start();
         */
    }
}

class MyThread1 extends Thread{
    // Die run Methode in der Thread Klasse, hat keine Aufgabe. Ohne Override, wird nichts ausgeführt.
    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++){
            System.out.println(i);
        }
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 1000; i > 0; i--){
            System.out.println(i);
        }
    }
}

class MyThread3 implements Runnable{
    // Die run Methode in der Thread Klasse, hat keine Aufgabe. Ohne Override, wird nichts ausgeführt.
    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++){
            System.out.println(i);
        }
    }
}

class MyThread4 implements Runnable{
    @Override
    public void run() {
        for (int i = 1000; i > 0; i--){
            System.out.println(i);
        }
    }
}