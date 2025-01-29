package Multithreading.SynchronAsynchron.Volatile;
// Wichtig!: Funktioniert nur korrekt, wenn lediglich ein Thread Schreibt und andere Threads lesen.
public class VolatileExample extends Thread{
    // volatile -> Speichert den Wert nur im RAM (Main Memory), für alle Threads. Somit wirkt jede Veränderung für alle Threads.
   volatile boolean b = true;

    public void run(){
        long counter = 0;
        while(b){
            counter++;
        }
        System.out.println("Loop has finished. Counter = " + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileExample thread = new VolatileExample();
        thread.start();

        // Sleep auf Main, nicht auf thread
        Thread.sleep(3000);
        System.out.println("After three seconds it is time to wake up, Neo.");

        // Wenn nicht "volatile"
        // Wert wird im Cache von Main-Thread geändert, aber nicht auf RAM. Daher ist es unvorhersehrbar, wann der Wert "false" vom "Thread-0" übernommen wird.
        thread.b = false;
        thread.join();
        System.out.println("End of Programm.");
    }

}
