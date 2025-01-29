package Streams.Chaining;

import java.util.Arrays;

public class StreamChainingExample {
    public static void main(String[] args) {
        int[] array = {3, 8, 1, 5, 9, 12, 4, 21, 81, 7, 18};
/*
        array = Arrays.stream(array).filter((int element) ->
                {
                    if (element % 2 != 0) {
                        return true;
                    }
                    return false;
                }
        ).toArray();
        System.out.println(Arrays.toString(array));

 */

        //Chaining = verkettung mehrerer Methoden
        int result = Arrays.stream(array)
                .filter(e -> e % 2 != 0)                            // 3,1,5,9,21,81,7
                .map(e -> {if(e % 3 == 0){e = e/3;}return e;})      // 1,1,5,3,7,27,7
                .reduce((a,e) -> a+e)                           // 51
                .getAsInt();


        System.out.println(result);
    }
}
