package Multithreading.ThreadSafeMultithreadCollection.ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueExample2 {

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> abq = new ArrayBlockingQueue<>(4);

        // Producer
        new Thread (()-> {
            int i = 0;
            while(true){
                try {
                    abq.put(++i);
                    System.out.println("Producer added : " + i + " : " + abq);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        // Consumer
        new Thread (()-> {
            while(true){
                try {
                    Integer j =abq.take();
                    System.out.println("Consumer removed : " + j + " : " + abq);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
