package collection.Iterator.List.Iterator;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {
    public static void main(String[] args) {
        String s = "madam";
        List<Character> list = new LinkedList<>();

        for(char ch: s.toCharArray()){              // Jedes Zeichen aus der Zeichenkette wird in als Char in der Liste gespeichert
            list.add(ch);
        }

        System.out.println(list);   //[m, a, d, a, m]
        System.out.println("_______________________");


        // Der ListIterator hat die Methoden "hasNext" und "hasPrevious" um sowohl vorwärts als auch rückwärts suchen zu können.
        ListIterator<Character> iterator = list.listIterator();                         // startet bei Index 0
        ListIterator<Character> reverseIterator = list.listIterator(list.size());       // startet beim letzten Index

        boolean isPalindrome = true;

        // In unserem Fall, geht .hasPrevious() bis zum ersten Index durch und .hasNext() bis zum letzten
        // Dies ist nicht das beste Beispiel, für die Vorführung reicht es jedoch aus.
        while(iterator.hasNext() && reverseIterator.hasPrevious()){
            if(iterator.next() != reverseIterator.previous()) {
                isPalindrome = false;
                break;
            }
        }
        if(isPalindrome){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not a Palindrome");
        }
        System.out.println("_______________________");

    }
}
