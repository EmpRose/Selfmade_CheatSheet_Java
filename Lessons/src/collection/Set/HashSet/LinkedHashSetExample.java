package collection.Set.HashSet;



import java.util.LinkedHashSet;
import java.util.Objects;

public class LinkedHashSetExample {
    public static void main(String[] args) {

        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(5);
        lhs.add(3);
        lhs.add(1);
        lhs.add(8);
        lhs.add(10);
        // Reihenfolge wird eingehalten
        System.out.println(lhs);

        // Methoden
        // .remove(key)
        // .contains(key)


    }
}

class Students implements Comparable<Students> {

    String name;
    int course;

    public Students(String name, int course) {
        this.name = name;
        this.course = course;
    }


    @Override
    public int compareTo(Students other) {
        return this.course - other.course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Students student = (Students) o;
        return course == student.course;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course);
    }
}
