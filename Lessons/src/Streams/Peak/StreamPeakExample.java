package Streams.Peak;

import java.util.stream.Stream;

// wie "forEach" aber der Rückgabewert ist nicht void, sondern ein Stream
public class StreamPeakExample {
    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1,2,3,4,5,1,2,3);
        // Rückgabe der Elemente im Stream und die Anzahl der Elemente
        System.out.println(stream1.distinct().peek(System.out::println).count());
    }
}
