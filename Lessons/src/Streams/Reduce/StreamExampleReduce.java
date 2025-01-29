package Streams.Reduce;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
// .reduce() gibt immer ein Element aus einer Collection als Rückgabewert zurück. (Beispiel: Durchschnittswert oder Summe)

public class StreamExampleReduce {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(8);
        list.add(2);
        list.add(4);
        list.add(3);

        int result = list.stream().reduce((accumulator, element) ->
                accumulator * element).get(); //.get() notwendig da Optional (Wrapt ein Object), kann "null" und "notNull" beinhalten

        System.out.println(result);
        // 5, 8, 2, 4, 3
        // accumulator  =  5   40  80  320  960
        // element      =  8    2   4    3

        // Durch die übergabe der"identity" - erster Wert für accumulator, erhalten wir definitiv ein int zurück.
        // .get() ist dem nach, nicht mehr notwendig.
        int result2 = list.stream().reduce(1, (accumulator, element) ->
                accumulator * element);
        System.out.println(result2);
        // 5, 8, 2, 4, 3
        // accumulator  =   1   5   40  80  320  960
        // element      =   5   8   2    4    3

        //Eine leere Liste, hat natürlich auch keine Elemente =)
        List<Integer> list100 = new ArrayList<>();
        Optional<Integer> o = list100.stream().reduce((accumulator, element) ->
                accumulator * element);
        if (o.isPresent()) {
            System.out.println(o.get());
        } else {
            System.out.println("Empty Value");
        }


        List<String> listS = new ArrayList<>();

        listS.add("privet");
        listS.add("kak dela?");
        listS.add("OK");
        listS.add("poka");

        // wird der accumulator hier nicht mehrfach genutzt wie bei int, weil der Wert sich nicht verändert?
        // Weitere Prüfungen notwendig.
        String result3 = listS.stream().reduce((a, e) ->
                a + "  " + e).get();
        System.out.println(result3);

        /*
        •	Beim ersten Schritt:
	    •	a = "privet" (erster Wert aus der Liste)
	    •	e = "kak dela?" (zweiter Wert aus der Liste)
	    •	Ergebnis: "privet kak dela?"
	    •	Beim zweiten Schritt:
	    •	a = "privet kak dela?" (neuer accumulator)
	    •	e = "OK" (dritter Wert aus der Liste)
	    •	Ergebnis: "privet kak dela? OK"
	    •	Beim dritten Schritt:
	    •	a = "privet kak dela? OK"
	    •	e = "poka" (vierter Wert aus der Liste)
	    •	Ergebnis: "privet kak dela? OK poka"

         */
    }
}
