package Streams.CollectGroupingAndPartitioning;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Populäre Methoden bei der Anwendung von Streams
public class GoupingAndPartitioningExample {
    public static void main(String[] args) {

        Student st1 = new Student("Ivan", "m", 22, 3, 8.3);
        Student st2 = new Student("Nikolay", "m", 28, 2, 6.4);
        Student st3 = new Student("Elena", "f", 19, 1, 8.9);
        Student st4 = new Student("Petr", "m", 35, 4, 7);
        Student st5 = new Student("Mariya", "f", 23, 3, 7.4);

        List<Student> students = new ArrayList<>();
        List<Student> students2 = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        System.out.println("______GroupingBy______");
        // GroupingBy -> Gruppiert anhand angegebener Werte (Course)
        // Key   /   Value -> Jeder Key, hat eine Liste mit Elementen. Jede Liste enthält einen Key und nur Elemente nach denen gruppiert wird.
        Map<Integer, List<Student>> map = students.stream().map(el-> {
            el.setName(el.getName().toUpperCase());
            return el;
        }).collect(Collectors.groupingBy(el-> el.getCourse())); // Gruppierung erfolgt anhand des Wertes "Course"

        for (Map.Entry<Integer, List<Student>> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue().toString());
        }

        System.out.println("______PartitioningBy______");

        // Key   /   Value -> Jeder Key, hat eine Liste mit Elementen. Zwei Listen mit True/False Werten
        Map<Boolean, List<Student>> map2 = students.stream().map(el-> {
            el.setName(el.getName().toUpperCase());
            return el;
        }).collect(Collectors.partitioningBy(el-> el.getAvgGrade() > 7)); // Partitionierung erfolgt anhand von Boolean, Note > 7

        for (Map.Entry<Boolean, List<Student>> entry : map2.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue().toString());
        }
    }
}

class Student {
    private String name;
    private String sex;
    private int age;
    private int course;
    private double avgGrade;

    public Student(String name, String sex, int age, int course, double avgGrade) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avgGrade = avgGrade;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public int getCourse() {
        return course;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", course=" + course +
                ", avgGrade=" + avgGrade +
                '}';
    }
}
