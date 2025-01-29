package Streams.ParallelStream;


import java.util.ArrayList;
import java.util.List;

// Mit "ParallelStream" erfolgt die Möglichkeit, mehrere Kerne der CPU für die Verarbeitung zu nutzen.
public class ParallelStreamExample {
    public static void main(String[] args) {


        List<Double> list = new ArrayList<>();
        list.add(10.0);
        list.add(5.0);
        list.add(1.0);
        list.add(0.25);

        // Nutzung von ParallelStream, ist nur dann sinnvoll, wenn die Reihenfolge der zu verarbeiteten Elemente nicht relevant ist.
        // Richtiger Einsatz
        //list.stream()...
        double sumResult = list.stream()
                .reduce((accumulator, element) -> accumulator + element)
                .get();
        System.out.println("sumResult = " + sumResult);

        //list.paralelStream()...
        double sumResult2 = list.parallelStream()
                .reduce((accumulator, element) -> accumulator + element)
                .get();
        System.out.println("sumResult2 = " + sumResult2);

        // Falscher Einsatz
        double devResult = list.stream()
                .reduce((accumulator,element)-> accumulator/element)
                .get();
        System.out.println("devResult1 = " + devResult);

        double devResult2 = list.parallelStream()
                .reduce((accumulator,element)-> accumulator/element)
                .get();
        System.out.println("devResult2 = " + devResult2);


    }
}

