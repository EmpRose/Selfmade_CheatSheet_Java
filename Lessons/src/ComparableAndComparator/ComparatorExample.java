package ComparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {

        List<Employees> list = new ArrayList<>();
        Employees emp1 = new Employees(100, "Zaur", "Tregulov", 12345);
        Employees emp2 = new Employees(15, "Ivan", "Petrov", 6542);
        Employees emp3 = new Employees(123, "Ivan", "Sidorov", 8542);

        list.add(emp1);
        list.add(emp2);
        list.add(emp3);

        System.out.println("Before sorting:");
        System.out.println(list);

        // Sortieren nach ID
        Collections.sort(list, new Comparator<Employees>() {
            @Override
            public int compare(Employees emp1, Employees emp2) {
                return Integer.compare(emp1.id, emp2.id);
            }
        });

        System.out.println("After sorting by ID:");
        System.out.println(list);

        // Sortieren nach Name
        Collections.sort(list, new Comparator<Employees>() {
            @Override
            public int compare(Employees emp1, Employees emp2) {
                return emp1.name.compareTo(emp2.name);
            }
        });

        System.out.println("After sorting by Name:");
        System.out.println(list);
    }
}

class Employees {
    int id;
    String name;
    String surname;
    int salary;

    public Employees(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }
}