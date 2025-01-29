package collection.Set.TreeSet;

import java.util.Objects;
import java.util.TreeSet;

public class TreeSetExample2 {

    public static void main(String[] args) {
        TreeSet<Student> treeSet = new TreeSet<>();

        Student st1 = new Student("Zaur",5);
        Student st2 = new Student("Misha",1);
        Student st3 = new Student("Igor",2);
        Student st4 = new Student("Marina",3);
        Student st5 = new Student("Olya" ,4);
        Student st6 = new Student("Ivan" ,2);

        treeSet.add(st1);
        treeSet.add(st2);
        treeSet.add(st3);
        treeSet.add(st4);
        treeSet.add(st5);

        System.out.println(treeSet);
        System.out.println(st3.equals(st6));
        System.out.println(st3.hashCode() == st6.hashCode());

        // Methoden
        // .first - gibt das erste/kleinste Wert zurück
        // .last - gibt das höchsten/letzten Element zurück
        // .headSet(key) - Gibt alle Werte unter dem Key an. (anfang bis key)
        // .tailSet(key) - Gibt alle Werte ab dem Key an. (key bis ende)
        // .subSet(key,key) - Gitb alle Werte zwischen den Keys zurück.
    }


}

class Student implements Comparable<Student>{

    String name;
    int course;

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }


    @Override
    public int compareTo(Student other) {
        return this.course-other.course;
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
        Student student = (Student) o;
        return course == student.course;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course);
    }
}
