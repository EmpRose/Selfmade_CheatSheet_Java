package collection.Map.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeExample1 {
    public static void main(String[] args) {
        Map<Student, Double> map = new HashMap<>();
        Student st1 = new Student("Matvej", "Pospelov", 3);
        Student st2 = new Student("Zaur", "Tregulov", 3);
        Student st3 = new Student("Sergey", "Petrov", 3);
        Student st4 = new Student("Matvej", "Pospelov", 3);
        Student st5 = new Student("Igor", "Sidorov", 4);

        map.put(st1, 7.5);
        map.put(st2, 8.7);
        map.put(st3, 9.2);
        System.out.println(map);
        System.out.println("__________________________");


        // Rückgabe "false"; weil nur equals überschrieben wurde
        boolean result = map.containsKey(st4);
        System.out.println("result = " + result);
        // Für "equals" sind die Elemente identisch - deshalb muss auch "hashCode" überschrieben werden, da der HashCode sich unterscheidet.
        System.out.println(st1.equals(st4));
        System.out.println("__________________________");

        // .hashCode gibt den Hash-Wert zurück
        // - Verschiedene hashCodes - verschiedene Elemente. Bei gleichen muss auch der hashCode übereinstimmen
        System.out.println(st5.hashCode());
        System.out.println(st2.hashCode());
        System.out.println("__________________________");

        for (Map.Entry<Student, Double> entry : map.entrySet()) { // Entry ist ein Interface für die Map Klasse(Node) und gibt die vorhandene Menge an Key/Value zurück
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("__________________________");

    }

}

class Student {
    String name;
    String surname;
    int course;

    public Student(String surname, String name, int course) {
        this.surname = surname;
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surename='" + surname + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && Objects.equals(name, student.name) && Objects.equals(surname, student.surname);
    }

    // Wandelt ein beliebiges Object in ein int. Vergibt einem Object einen entsprechenden HashCode.
    // Es kann zu einer Koallision führen, wenn der HashCode verschiedener Objekte, gleich ist.
    // Ein Integer hat jedoch nur einen bestimmten maximalen Wert, daher kann auch hier eine Koallision nicht komplett ausgeschlossen werden.
    // Darum werden zwei Überprüfungen angewendet. Equals und HashCode (HashCode kann identisch sein, wenn equals == false ist)
    @Override
    public int hashCode() {
        return Objects.hash(name, surname, course);
        // return name.length()*7 + surname.length()*11 + course*53;
    } // Fast alle Elemente zum selben HashCode zusammen


    // Auf diese Weise , kann man den Kollisionen entgegenwirken und verschiedene Werte erhalten
    /*
    @Override
    public int hashCode() {
        return name.length()*7 + surname.length()*11 + course*53;
    }

     */

}
