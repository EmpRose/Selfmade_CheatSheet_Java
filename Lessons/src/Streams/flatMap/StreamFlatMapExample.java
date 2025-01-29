package Streams.flatMap;

import java.util.ArrayList;
import java.util.List;

//
public class StreamFlatMapExample {
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", "m", 22, 3, 8.3);
        Student st2 = new Student("Nikolay", "m", 28, 2, 6.4);
        Student st3 = new Student("Elena", "f", 19, 1, 8.9);
        Student st4 = new Student("Petr", "m", 35, 4, 7);
        Student st5 = new Student("Mariya", "f", 23, 3, 7.4);

        Faculty f1 = new Faculty("Economics");
        Faculty f2 = new Faculty("Applied mathematics");

        f1.addStudentToFaculty(st1);
        f1.addStudentToFaculty(st2);
        f1.addStudentToFaculty(st3);
        f2.addStudentToFaculty(st4);
        f2.addStudentToFaculty(st5);

        List<Faculty> facultyList = new ArrayList<>();
        facultyList.add(f1);
        facultyList.add(f2);

        System.out.println("____sout____");
        System.out.println(facultyList);

        System.out.println("____sout with flat Map____");
        facultyList.stream().flatMap(faculty -> faculty.getStudentsOnFaculty().stream()).forEach(e->System.out.println(e.getName()));
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

class Faculty{
    String name;
    List<Student> studentsOnFaculty;

    public Faculty(String name) {
        this.name = name;
        studentsOnFaculty = new ArrayList<>();
    }

    public List<Student> getStudentsOnFaculty() {
        return studentsOnFaculty;
    }

    public void addStudentToFaculty(Student st){
        studentsOnFaculty.add(st);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", studentsOnFaculty=" + studentsOnFaculty +
                '}';
    }
}
