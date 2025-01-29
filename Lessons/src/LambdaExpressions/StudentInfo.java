package LambdaExpressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Test {
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", "m", 22, 3, 8.3);
        Student st2 = new Student("Nikolay", "m", 28, 2, 6.4);
        Student st3 = new Student("Elena", "f", 19, 1, 8.9);
        Student st4 = new Student("Petr", "m", 35, 4, 7.0);
        Student st5 = new Student("Mariya", "f", 23, 3, 9.1);

        StudentInfo info = new StudentInfo();
        ArrayList<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);


        // Kurze Lambda Ausdrücke -> Lesbarer und ohne einer anonymen Klasse die das Interface implementiert und die Methode überschreibt.
        info.testStudents(students, (Student s) -> {
            return s.age < 30; //return s.age > 20 && s.avgGrade < 9.3 && s.sex == "f";
        });
        System.out.println("_______________");

        // Lambda - noch kürzer
        // Das angesprochene Interface, hat nur eine abstrakte Methode. Daher weiß Java, dass "s" sich auf die Student Klasse bezieht.
        info.testStudents(students, s -> s.name != "");

        System.out.println("_______________");

        // Lambda Wert in einer Variablen ablegen für häufigere Nutzung der Werte
        StudentChecks sc = s -> s.name != "";
        info.testStudents(students, sc);

        System.out.println("_______________");

        for (Student st : students) {
            System.out.println(st.course);
        }

        //Compare mit Lambda und einer anonymen Klasse
        /*
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student st1, Student st2) {
                return st1.course- st2.course;
            }
        });
        System.out.println("_______________");
        for(Student st: students){
            System.out.println(st.course);
        }
         */

        // Compare mit Lambda, ohne einer anonymen Klasse
        Collections.sort(students, (s1, s2) -> s1.course - s2.course);

        System.out.println("_______________");

        for (Student st : students) {
            System.out.println(st.course);
        }

    }
}

public class StudentInfo {

    public void testStudents(ArrayList<Student> al, StudentChecks sc) {
        for (Student s : al) {
            if (sc.check(s)) {
                System.out.println(s);
            }
        }
    }
}

// Funktionales Interface mit einer abstrakten Methode
interface StudentChecks {
    boolean check(Student s);
}

// Klasse die das Interface implementiert
class CheckOverGrade implements StudentChecks {
    @Override
    public boolean check(Student s) {
        return s.avgGrade > 8;
    }
}
