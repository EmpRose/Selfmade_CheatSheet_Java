package Streams.Distinct;

import java.util.stream.Stream;

// Prüft auf die "unique" der Elemente im Stream und hat einen "equals" Rückgabewert
public class StreamDistinctExample {

    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1,2,3,4,5,1,2,3);
        stream1.distinct().forEach(System.out::println); // 1,2,3,4,5
    }
}
