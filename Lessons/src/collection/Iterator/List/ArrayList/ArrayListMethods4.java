package collection.Iterator.List.ArrayList;

import java.util.Arrays;
import java.util.List;

public class ArrayListMethods4 {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("A");
        StringBuilder sb2 = new StringBuilder("B");
        StringBuilder sb3 = new StringBuilder("C");
        StringBuilder sb4 = new StringBuilder("D");

        // Array.asList(DataType[]) -> List<DataType>

        StringBuilder[] array = {sb1,sb2,sb3,sb4};
        List<StringBuilder> list = Arrays.asList(array);    // Die Länge der Liste wird immer identsich zum Array sein.
                                                            // Jede Veränderung, wirkt sich auf die "Liste" ebenfalls aus.
        System.out.println(list); //[A, B, C, D]
        System.out.println("_______________________________________");

        array[0].append("!!!");
        System.out.println(list); //[A!!!, B, C, D]
        System.out.println("_______________________________________");

        array[0] = new StringBuilder("F");
        System.out.println(list); //[F, B, C, D]
        System.out.println("_______________________________________");


    }
}
