package LambdaExpressions.Predicate;

import java.util.ArrayList;
import java.util.function.Predicate;

public class RemoveIfExample {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("privet");
        al.add("poka");
        al.add("ok");
        al.add("uchim java");
        al.add("a imenno, lambdas");

        al.removeIf(element -> element.length()<5);
        System.out.println(al);

        System.out.println("_______________");

        Predicate<String> p = element -> element.length() < 5;
        al.removeIf(p);
        System.out.println(al);

    }
}
