package Queue;

import java.util.Objects;
import java.util.PriorityQueue;

public class PriorityQueueExample2 {
    public static void main(String[] args) {

        Std st1 = new Std("Zaur",5);
        Std st2 = new Std("Misha",1);
        Std st3 = new Std("Igor",2);
        Std st4 = new Std("Marina",3);
        Std st5 = new Std("Olya",4);



        PriorityQueue<Std> pq = new PriorityQueue<>();
        pq.add(st1);
        pq.add(st2);
        pq.add(st3);
        pq.add(st4);
        pq.add(st5);

        System.out.println(pq);
        // Das Element mit der höchsten Priorität wird gelöscht, unabhöngig der Reihenfolge in der Ausgabe mit sout
        System.out.println(pq.poll());
        System.out.println(pq);

    }
}

class Std implements Comparable<Std>{
    String name;
    int course;

    public Std(String name, int course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public int compareTo(Std other) {
        return this.course- other.course;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Std std = (Std) o;
        return course == std.course;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course);
    }

    @Override
    public String toString() {
        return "Std{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }
}
