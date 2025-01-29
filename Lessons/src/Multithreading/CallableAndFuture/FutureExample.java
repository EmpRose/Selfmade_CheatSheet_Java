package Multithreading.CallableAndFuture;
// Future, beschreibt eine Situation, in der ein Wert noch nicht zurück erhalten wurde.
// Der Thread, wird so lange gehalten, bis der Task, der den Rückgabewert liefert, fertig wird.

// Im Klartext, der Main-Thread in unserem Beispiel, der den Rückgabewert von einem Thread erwartet, der mit einem Task beschäftigt ist.
// Bleibt so lange blockiert bis ein Rückgabewert geliefert wird und arbeitet dann erst weiter.
// Await Termination ist nicht notwendig
import java.util.concurrent.*;

public class FutureExample {

    static int factorialResult;
    public static void main(String[] args) {


        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial3 factorial = new Factorial3(6);


        Future<Integer> future = executorService.submit(factorial);

        try {
            // Fragt ab, ob ein Task beendet wurde
            System.out.println("Is the Task done? true/false : " + future.isDone());
            System.out.println("Waiting for the result");
            // Erst wenn der Task fertig ist und ein Rückgabewert oder eine Excaption geliefert werden,
            // erfolgen die nächsten Schritte im Main-Thread.
            // Await Termination ist daher nicht notwendig.
            factorialResult = future.get();
            System.out.println("Got the Result");
            System.out.println("Is the Task done? true/false : " + future.isDone());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            System.out.println(e.getCause());
        }finally {
            executorService.shutdown();
        }


        System.out.println(factorialResult);
    }
}

class Factorial3 implements Callable<Integer> {
    int f;

    public Factorial3(int f) {
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {
        if (f<=0){
            throw new Exception("Wrong input!");
        }
        int result = 1;
        for (int i = 1; i <= f; i++){
            result *= i;
            Thread.sleep(1000);
        }
        return result;
    }
}
