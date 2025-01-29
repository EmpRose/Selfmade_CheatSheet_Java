package collection.Iterator.List.LinkedList;

import Klassen.Student2;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {

        Student2 st1 = new Student2 ("Ivan",3);
        Student2 st2 = new Student2 ("Nikolay",2);
        Student2 st3 = new Student2 ("Elena",1);
        Student2 st4 = new Student2 ("Petr",4);
        Student2 st5 = new Student2 ("Mariya",3);
        LinkedList<Student2> students = new LinkedList<>();

        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        System.out.println("LinkedList = " + students);

        // .get Gibt den Wert vom Index zurück
        System.out.println(students.get(2));

        // .remove() Löscht das Element am genannten Index
        // Dabei wird das Object selbst nicht gelöscht, es wird lediglich aus der Liste entfernt.
        students.remove(3);

    }
}
