package Multithreading.ThreadPoolExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample1 {

    public static void main(String[] args) throws InterruptedException {
        //ExecutorService executorService = new ThreadPoolExecutor();
        // Erzeugt ein pool mit einem Thread
        //ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Erzeugt ein pool mit (n) Threads -> Executors = Klasse , newFixedThreadPool = Methode der Klasse Executors
        //ExecutorService executorService = Executors.newFixedThreadPool(5);

        //Alle Aufgaben werden mit einem Thread, nacheinander ausgeführt
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++){
            // execute-Methode übergibt die Task zum Thread-Pool
            executorService.execute(new RunnableImpl());
        }
        // Das Program wird weiter arbeiten, bis wir executorService ausschalten.
        // Wir setzen das Zeichen, dass keine Aufgaben mehr folgen
        executorService.shutdown();

        // Bringt Thread in dem aufgerufen, zu warten. In diesem Fall Main-Thread
        // Main-Thread wartet auf Erfüllung aller Aufgaben oder Ablauf der angegebenen Zeit (5 Sekunden)
        // Erst darauf, läuft der Main-Thread weiter
        executorService.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Main Ends");
    }
}

class RunnableImpl implements Runnable{
    public void run(){
        System.out.println(Thread.currentThread().getName() + " start");
        // der Task(sout) ist so klein, dass ohne "sleep" ein Thread auch alle Aufgaben allein erfüllen kann.
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " finish");
    }
}