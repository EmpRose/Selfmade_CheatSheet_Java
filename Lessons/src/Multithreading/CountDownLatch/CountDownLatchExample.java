package Multithreading.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/*
CountDownLatch ist ein Synchronizator, der es Threads ermöglicht zu warten, bis eine gewisse Anzahl von Tasks erfüllt wurde.
In dem Construktor von CountDownLatch, muss die Anzahl der Tasks angegeben werden, die beendet werden müssen,
damit die Threads ihre Arbeit "abseids" fortführen können.

.await()
.countDown()
.getCount()

BlackFriday Beispiel:
Bevor die Menschen aus der Warteschlange in den Laden kommen um Ihre Aufgaben zu erledigen, müssen Mitarbeiter:innen zur Arbeit kommen,
das Licht muss eingeschaltet werden,
die Artikel müssen auf den Regalen ausgelegt werden
und der Laden muss öffnen.

P.S.: Erst wenn die Anzahl der Tasks erfüllt wurde, können Threads beginnen zu arbeiten.
 */
public class CountDownLatchExample {
    static CountDownLatch countDownLatch = new CountDownLatch(4);
    private static void marketStaffIsOnPlace() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Market stuff arived.");
        countDownLatch.countDown();
        System.out.println("countDownLatch : " + countDownLatch.getCount());
    }

    private static void LightsAreOn() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("The Lights are on.");
        countDownLatch.countDown();
        System.out.println("countDownLatch : " + countDownLatch.getCount());
    }

    private static void WorkIsDone() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("The Workers are done.");
        countDownLatch.countDown();
        System.out.println("countDownLatch : " + countDownLatch.getCount());
    }

    private static void TheDoorsAreOpen() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("The Market opened.");
        countDownLatch.countDown();
        System.out.println("countDownLatch : " + countDownLatch.getCount());
    }

    public static void main(String[] args) throws InterruptedException {
        new Friend("Zaur", countDownLatch);
        new Friend("Oleg", countDownLatch);
        new Friend("Elena", countDownLatch);
        new Friend("Viktor", countDownLatch);
        new Friend("Marina", countDownLatch);

        marketStaffIsOnPlace();
        LightsAreOn();
        WorkIsDone();
        TheDoorsAreOpen();

    }
}

class Friend extends Thread{
    String name;
    private CountDownLatch countDownLatch;

    public Friend(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();
    }

    public void run(){
        // Die Threads werden gehalten, bis der Countdown die "0" erreicht.
        try {
            countDownLatch.await();
            System.out.println(name + " starts with the shoppingtour.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
