package Multithreading.ThreadMethodsExample;
// Name and Priority Example
public class ThreadNamePriorityExample {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        MyThread thread2 = new MyThread();

        // Priorität des Threads ist standardmässig auf 5. Die Skala liegt bei 1 bis 10 (10 ist am wichtigsten).
        // Priorität und Bennenung sind veränderbar.
        System.out.println("_____Standard_____");
        System.out.println("Name of thread: " + thread.getName() +
                ". Priority of thread: " + thread.getPriority());
        System.out.println("Name of thread: " + thread2.getName() +
                ". Priority of thread: " + thread2.getPriority());

        thread.setName("Thread the first");
        //thread.setPriority(9);
        // Auch vorgefertigte Einstellungen sind vorhanden -> sorgt für bessere Lesbarkeit
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("_____Angepasst_____");
        System.out.println("Name of thread: " + thread.getName() +
                ". Priority of thread: " + thread.getPriority());
    }


}


class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("Hi, There!");
    }
}