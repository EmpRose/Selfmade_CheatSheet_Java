package collection.Iterator.List.Vector.Stack;

import java.util.Stack;

public class StackExample2 {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        // .push - Fügt das letzte Element ganz oben auf den Stack (Ende der Reihe) Katya liegt ganz oben auf den Stack
        stack.push("Zaur");
        stack.push("Misha");
        stack.push("Oleg");
        stack.push("Katya");
        System.out.println(stack);
        System.out.println("____________");

        // .pop Gibt das obere Element eines Stacks zurück und löscht es anschließend (Exeption, wenn Stack empty ist)
        //System.out.println(stack.pop());
        //System.out.println(stack);
        //System.out.println("____________");

        // .isEmpty prüft ob das Stack leer ist
        //while(!stack.isEmpty()){
        //    System.out.println(stack.pop());
        //    System.out.println(stack);
        //    System.out.println("____________");
        //}

        // .peek Gibt das obere Element eines Stacks zurück, ohne dieses zu löschen.
        System.out.println(stack.peek());
        System.out.println(stack);


    }
}
