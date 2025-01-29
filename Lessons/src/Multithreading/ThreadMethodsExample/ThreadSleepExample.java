package Multithreading.ThreadMethodsExample;

public class ThreadSleepExample extends Thread{
    @Override
    public void run() {
        for (int i = 1 ; i <= 10; i++){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        // Sleep
        /*
        for (int i = 5; i > 0; i--){
            System.out.println(i);
            Thread.sleep(1000); // 1000 msek -> 1 sek
        }
        System.out.println("Lets go!");
         */

        Thread thread1 = new Thread(new MyRunnable1());
        ThreadSleepExample thread2 = new ThreadSleepExample();

        // Nach dem Start der Threads, arbeiten diese selbstständig und unabhängig von Main,
        // sodass Main seine Arbeit weiterführt. Deshalb kommt die Nachricht "End of Line" vor der Ausgabe der Threads
        // P.S.: Die Ausgabe der Threads erfolgt ja verlangsamt mit .sleep()
        thread1.start();
        thread2.start();
        System.out.println("End of Line");
    }
}

class MyRunnable1 implements Runnable{
    @Override
    public void run() {
        for (int i = 1 ; i <= 10; i++){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}