package Multithreading.ThreadMethodsExample;

public class ThreadRunStartExample implements Runnable {
    @Override
    public void run() {
        // currentThread - statische Methode (Gibt an in welchem Thread wir uns befinden)
        System.out.println("Method run. Thread name = " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadRunStartExample());

        // Ausführen mit .start();
        thread.start();
        System.out.println("Method main. Thread name = " + Thread.currentThread().getName());

        // Ausführen mit .run();
        thread.run();
        System.out.println("Method main. Thread name = " + Thread.currentThread().getName());

        // Beim Ausführen der Methode .run(), wird kein neuer Thread genutzt/ erstellt, sondern wird als Teil des aktuellen Threads mit ausgeführt (main)
        // Das heißt, .run() wird als normale Methode im bestehenden Thread ausgeführt.
    }
}
