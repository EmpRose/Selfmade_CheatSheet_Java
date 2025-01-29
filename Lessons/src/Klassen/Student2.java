package Klassen;

public class Student2 {
    String name;
    int course;

    public Student2(String name, int course){
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString(){
        return "Student {" +
                "Name: " + name +
                ", Course: " + course + " }";
    }
}
