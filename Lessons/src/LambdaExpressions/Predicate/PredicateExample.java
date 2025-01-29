package LambdaExpressions.Predicate;
import java.util.ArrayList;
import java.util.function.Predicate;
import LambdaExpressions.Student;
import LambdaExpressions.StudentInfo;

// Mit dem Interface "Predicate" entfällt die notwendigkeit, ein eigenes funktionales Interface anzulegen
// Das Predicate Interface kann unterschiedliche Objecte annehmen

// public interface Predicate<T> {boolean test (T t)};

public class PredicateExample {

    public static void main(String[] args) {
        Student st1 = new Student("Ivan", "m", 22, 3, 8.3);
        Student st2 = new Student("Nikolay", "m", 28, 2, 6.4);
        Student st3 = new Student("Elena", "f", 19, 1, 8.9);
        Student st4 = new Student("Petr", "m", 35, 4, 7.0);
        Student st5 = new Student("Mariya", "f", 23, 3, 9.1);

        // StudentInfo2 -> veränderte Werte in der Methode "testStudents" von StudentCheck auf Predicate
        StudentInfo2 info = new StudentInfo2();
        ArrayList<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        System.out.println("__________Grade < 10____________");
        info.testStudents(students,(Student p)->{
            return p.getAvgGrade() < 10 ;
    });

        System.out.println("__________Grade > 8____________");

        info.testStudents(students, p -> p.getAvgGrade() > 8);

        System.out.println("____________AND_____________");

        //RemoveIf -> entfernt ein Element , wenn Rückgabewert = true.
        Predicate<Student> p1 = student -> student.getAvgGrade() > 7.5;
        Predicate<Student> p2 = student -> student.getSex() == "m";

        // element.and(element2)
        // Analog zum Join, gibt nur Elemente zurück die sowohl p1 als auch p2 entsprechen
        info.testStudents(students, p1.and(p2));

        // element.or(element2)
        // Gibt Elemente zurück, bei denen entweder p1 oder p2 true ist
        System.out.println("____________OR_____________");
        info.testStudents(students, p1.or(p2));


        // element.negate()
        // Elemente die für p1 False zurückgeben
        System.out.println("___________NEGATE___________");
        info.testStudents(students,p1.negate());

    }

}


// Predicate hat nur die Methode "test"
class StudentInfo2 {
    void testStudents(ArrayList<Student> al, Predicate<Student> pr){
        for (Student s : al){
            if (pr.test(s)){
                System.out.println(s);
            }
        }
    }
}