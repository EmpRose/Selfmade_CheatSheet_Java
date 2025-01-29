package Streams.Sorted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSortedExample {

    public static void main(String[] args) {
        int[] array = {3,8,1,5,9,12,4,21,81,7,18};

        array = Arrays.stream(array).sorted().toArray();
        System.out.println(Arrays.toString(array));

        Student st1 = new Student("Ivan", "m", 22, 3, 8.3);
        Student st2 = new Student("Nikolay", "m", 28, 2, 6.4);
        Student st3 = new Student("Lena", "f", 19, 1, 8.9);
        Student st4 = new Student("Petr", "m", 35, 4, 7);
        Student st5 = new Student("Mariya", "f", 23, 3, 7.4);

        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        List<Student> students2 = new ArrayList<>();
        List<Student> students3 = new ArrayList<>();

        System.out.println("____Sorted_by_Class_Comparable____Age");

        students2 = students.stream().sorted().collect(Collectors.toList());
        System.out.println(students2);

        System.out.println("____Sorted_by_Lambda____Name");

        //students3 = students.stream().sorted(Comparator.comparing(Student::getName)).collect(Collectors.toList());
        students3 = students.stream().sorted((x,y)->
                x.getName().compareTo(y.getName())).collect(Collectors.toList());
        System.out.println(students3);

    }
}

class Student implements Comparable<Student>{
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

    @Override
    public int compareTo(Student o) {
        return age-o.age;
    }


}