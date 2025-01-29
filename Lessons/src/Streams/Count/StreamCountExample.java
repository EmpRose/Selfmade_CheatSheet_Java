package Streams.Count;

import java.util.stream.Stream;

// Zählt die Anzahl der Elemente im Stream: Long als Rückgabewert
public class StreamCountExample {
    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1,2,3,4,5,1,2,3);

        //System.out.println(stream1.count());
        // Der selbe Stream, kann nicht genutzt werden, nach dem er breits eingesetzt wurde
        System.out.println(stream1.distinct().count());

    }
}
