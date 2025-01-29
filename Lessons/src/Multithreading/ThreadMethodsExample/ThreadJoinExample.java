package Multithreading.ThreadMethodsExample;

public class ThreadJoinExample extends Thread{

        @Override
        public void run() {
            for (int i = 1 ; i <= 10; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }


        public static void main(String[] args) throws InterruptedException {
            // Main-Thread startet (eig schon vorher)
            System.out.println("Start of Line");

            Thread thread1 = new Thread(new MyRunnable2());
            ThreadJoinExample thread2 = new ThreadJoinExample();
            thread1.start();
            thread2.start();

            // Der "main" Haupt-Thread, wird auf Threads1 und 2 warten, bevor er weiter arbeitet.
            thread1.join(5000); // Der Main-Thread, wartet entweder bis 5 sek auf das Ende der Threads und geht dann weiter
            thread2.join(1500); // Oder geht weiter, wenn die Threads fertig sind, unabhängig der Wartezeit

            // erst wenn beide Threats fertig sind, arbeitet der Main-Thread weiter.
            System.out.println("End of Line");
        }
    }

    class MyRunnable2 implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }