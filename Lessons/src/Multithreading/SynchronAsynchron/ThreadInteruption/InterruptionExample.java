package Multithreading.SynchronAsynchron.ThreadInteruption;

public class InterruptionExample {
/*
Es besteht die Möglichkeit einem Thread das Signal zu senden, dass dieser unterbrochen werden soll.
Im Thread selbst, besteht die Option zu prüfen, ob der Thread versucht wird unterbrochen zu werden.
Es liegt an uns, was wir mit der Information machen und ob der Thread unterbrochen werden soll.
 */

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main started.");
        InterruptedThread thread = new InterruptedThread();
        thread.start();
        Thread.sleep(2000);
        // Thread unterbrechen -> Anfrage
        thread.interrupt();

        thread.join();
        System.out.println("Main ended.");
    }
}


class InterruptedThread extends Thread{
    double sqrtSum=0;
    public void run(){
        for (int i = 1; i <= 1000000000; i++){
            // Abfrage -> besteht ein Versuch, den Thread zu unterbrechen?
            if (isInterrupted()){
                System.out.println("Try to interrupt the Thread");
                System.out.println("Interruption of Thread success");
                System.out.println(sqrtSum);
                return;
            }
            sqrtSum+=Math.sqrt(i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Interruption while thread sleeps. Lets finish the work.");
                System.out.println(sqrtSum);
                return;
            }
        }
        System.out.println(sqrtSum);
    }
}