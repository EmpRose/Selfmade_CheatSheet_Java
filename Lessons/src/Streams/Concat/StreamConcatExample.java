package Streams.Concat;

import java.util.stream.Stream;
// .concat() Verbindet Streams
public class StreamConcatExample {
    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1,2,3,4,5,1,2,3);
        Stream<Integer> stream2 = Stream.of(1,2,3,4,5);
        Stream<Integer> stream3 = Stream.of(6,7,8,9,10);

        // concat.() ist statisch und hat einen Stream als Rückgabewert kann aber nicht in einer Kette genutzt werden (chain)
        // Weder "Terminal" noch "Intemidiate" sind hierfür die richtige Bezeichnung
        Stream<Integer> stream4 = Stream.concat(stream2,stream3); //statischer Stream

        stream4.forEach(System.out::println);

    }
}
