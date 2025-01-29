package Multithreading.Semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {
        Semaphore callBox = new Semaphore(2);


        new Person("Zaur",callBox);
        new Person("Oleg",callBox);
        new Person("Elena",callBox);
        new Person("Viktor",callBox);
        new Person("Marina",callBox);
    }
}

class Person extends Thread{
    String name;
    private Semaphore callBox;

    public Person(String name, Semaphore callBox) {
        this.name = name;
        this.callBox = callBox;
        this.start();
    }

    public void run(){
        try {
            System.out.println(name  + " is waiting.");
            // .acquire() ->
            // Versucht die Genehmigung von Semaphore zur Verarbeitung zu erhalten
            // Der Thread wird solange blockiert, bis Semaphore die Genehmigung zur Verarbeitung erteilt
            callBox.acquire();
            System.out.println(name + " is using the Phonebox.");
            sleep(2000);
            System.out.println(name + " leave the Callbox.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            // .release()
            // Sehr wichtig um auf dem Semaphore, die belegte Position wieder frei zu geben.
            // Semaphore counter steigt um eine Position
            callBox.release();
        }
    }
}
