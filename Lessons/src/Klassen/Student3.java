package Klassen;

import java.util.Objects;

public class Student3 implements Comparable<Student3> {
    String name;
    String surname;
    int course;


    public Student3(String surname, String name, int course) {
        this.surname = surname;
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student3{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", course=" + course +
                '}';
    }
    @Override
    public int compareTo(Student3 o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student3 student3 = (Student3) o;
        return course == student3.course && Objects.equals(name, student3.name) && Objects.equals(surname, student3.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, course);
    }
}
