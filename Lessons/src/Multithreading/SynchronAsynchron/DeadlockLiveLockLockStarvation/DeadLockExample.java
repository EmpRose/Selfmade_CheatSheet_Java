package Multithreading.SynchronAsynchron.DeadlockLiveLockLockStarvation;
// Unter Umständen wird es zu einem "DeadLock" kommen und beide Threads werden unendlich auf einander warten.
// Daher ist es obligatorisch, die Reihenfolge der Zugriffe, identisch zu halten.
public class DeadLockExample {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread10 thread10 = new Thread10();
        Thread20 thread20 = new Thread20();

        thread10.start();
        thread20.start();

        /*
        Tread10: Try to catch the Monitor from Object Lock1
        Tread10: Catch of the Monitor from Object Lock1 success
        Tread20: Try to catch the Monitor from Object Lock2
        Tread20: Catch of the Monitor from Object Lock2 success
        ___________________________________________________
        Tread20: Try to catch the Monitor from Object Lock1
        ___________________________________________________
        Tread10: Try to catch the Monitor from Object Lock2
         */
    }

}


class Thread10 extends Thread{
    public void run(){
        System.out.println("Tread10: Try to catch the Monitor from Object Lock1");
        synchronized (DeadLockExample.lock1){
            System.out.println("Tread10: Catch of the Monitor from Object Lock1 success");
            System.out.println("___________________________________________________");
            System.out.println("Tread10: Try to catch the Monitor from Object Lock2");
            synchronized (DeadLockExample.lock2){
                System.out.println("Tread10: Catch of the Monitor from Object Lock1 andLock2 success");
            }
        }
    }
}

class Thread20 extends Thread{
    public void run(){
        System.out.println("Tread20: Try to catch the Monitor from Object Lock2");
        synchronized (DeadLockExample.lock2){
            System.out.println("Tread20: Catch of the Monitor from Object Lock2 success");
            System.out.println("___________________________________________________");
            System.out.println("Tread20: Try to catch the Monitor from Object Lock1");
            synchronized (DeadLockExample.lock1){
                System.out.println("Tread20: Catch of the Monitor from Object Lock2 andLock1 success");
            }
        }
    }
}