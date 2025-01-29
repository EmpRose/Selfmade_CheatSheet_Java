package Multithreading.CallableAndFuture;
/*
Das callable Interface, ähnelt dem Runnable Interface.
Allerdings verfügt es über einen <T> Rückgabewert und kann eine Ausnahme (Exception) werfen.
Die Methode zum Übergeben der Tasks in den Threadpool, unterscheidet sich (.submit())
Die .get() Methode, stellt das Rückgabewert zur Verfügung.
 */
import java.util.concurrent.*;

public class CallableFactorialExample {
    static int factorialResult;
    public static void main(String[] args) {


        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial2 factorial = new Factorial2(5);

        // Für Callable ist "execute" nicht vorhanden "submit" muss eingesetzt werden
        Future<Integer> future = executorService.submit(factorial);

        // mit .get erhalten wir das Resultat -> eine Excaption wird geworfen, da die Methode "call" es zulässt
        try {
            factorialResult = future.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            // Anzeigen des Grundes, warum eine Exception geworfen wurde
            // .getCause()
            System.out.println(e.getCause());
        }finally {
            executorService.shutdown();
        }


        System.out.println(factorialResult);
    }
}

class Factorial2 implements Callable<Integer>{
int f;

    public Factorial2(int f) {
        this.f = f;
    }

    // Die Call Methode des Callable Interfaces, kann eine Exception werfen und hat einen Rückgabewert (Generic)
    @Override
    public Integer call() throws Exception {
        if (f<=0){
            throw new Exception("Wrong input!");
        }
        int result = 1;
        for (int i = 1; i <= f; i++){
            result *= i;
        }
        return result;
    }
}