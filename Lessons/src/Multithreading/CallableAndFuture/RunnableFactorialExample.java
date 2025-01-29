package Multithreading.CallableAndFuture;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// 5! = 1 * 2 * 3 * 4 * 5 = 120
public class RunnableFactorialExample {
    static int factorialResult;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Factorial factorial = new Factorial(5);
        executorService.execute(factorial);
        executorService.shutdown();
        // Wenn der Main Thread nicht auf das Ende des Facotiral-Thread Tasks wartet,
        // wird der Task nicht früh genug fertig sein und das zurückgegebene Ergebnis ist damit falsch.
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(factorialResult);
    }
}

class Factorial implements Runnable{
    int f;

    public Factorial(int f) {
        this.f = f;
    }
    // Beim Interface "Runnable" ist es notwendig, eine Variable auserhalb der MEthode zu nutzen um ein Rückwert zu erhalten.
    // Auch ist es nicht möglich eine "Exception" zu werfen, auch wenn es nötig wäre.
    // Returntype = void
    public void run(){
        if (f <= 0){
            System.out.println("Wrong input!");
        }

        int result = 1;
        for (int i = 1; i<=f; i++){
            result *= i;
        }

        RunnableFactorialExample.factorialResult = result;
    }

    // Collable hat einen <T> Rückgabewert und wirft auch "Exception"

}
