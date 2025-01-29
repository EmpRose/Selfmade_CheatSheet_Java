package Streams.mapToInt;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Gibt einen Stream mit int-Wert zurück
public class MapToIntExample {
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", "m", 22, 3, 8.3);
        Student st2 = new Student("Nikolay", "m", 28, 2, 6.4);
        Student st3 = new Student("Elena", "f", 19, 1, 8.9);
        Student st4 = new Student("Petr", "m", 35, 4, 7);
        Student st5 = new Student("Mariya", "f", 23, 3, 7.4);

        List<Student> students = new ArrayList<>();
        List<Student> stdFlt = new ArrayList<>();

        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        List <Integer> courses = students.stream()
                .mapToInt(el->el.getCourse()) // .mapToDouble()
                .boxed()        // Achtung! .boxed() ist obligatorisch! Wandelt "int" zu "Integer"
                .collect(Collectors.toList());
        int sum = students.stream().mapToInt(el-> el.getCourse()).sum();
        double avg = students.stream().mapToInt(el-> el.getCourse()).average().getAsDouble();
        int min = students.stream().mapToInt(el-> el.getCourse()).min().getAsInt();
        int max = students.stream().mapToInt(el-> el.getCourse()).max().getAsInt();

        courses.stream().forEach(System.out::println);
        System.out.println(":");
        System.out.println(sum);
        System.out.println(min);
        System.out.println(max);
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