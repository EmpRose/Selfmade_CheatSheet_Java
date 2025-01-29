package Streams.ForEach;
// forEach() hat keinen Rückgabewert (void), kann daher nicht abgespeichert werden.
import java.util.Arrays;

public class StreamExampleForEach {
    public static void main(String[] args) {
        int[] array = {5, 9, 3, 8, 1};
        //Arrays.stream(array).forEach(value -> System.out.println(value));
        //Methode - Referenz (Angabe : Klasse :: Methode) Jedes Element wird der Methode einer Klasse als Parameter übergeben.
        Arrays.stream(array).forEach(System.out::println);
        Arrays.stream(array).forEach(value -> {
            value *= 2;
            System.out.println(value);
        });
        System.out.println("____My Method Example____");
        Arrays.stream(array).forEach(Utils::myMethod);
        // Arrays.stream(array).forEach(el -> Utils.myMethod(el));

    }
}

class Utils{
    public static void myMethod(int a){
         a = a+5;
        System.out.println("Element = " + a);
    }
}
