package ComparableAndComparator;

import java.util.*;

public class ComparableExample2 {
    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();
        Employee emp1 = new Employee(100,"Zaur","Tregulov",12345);
        Employee emp2 = new Employee(15,"Ivan","Petrov",6542);
        Employee emp3 = new Employee(123,"Ivan","Sidorov",8542);

        list.add(emp1);
        list.add(emp2);
        list.add(emp3);

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        // Die Sortierung schlägt fehl. Not comparable exception
        // Arrays.sort(new Employee [] {emp1,emp2,emp3});
    }
}

class Employee implements Comparable<Employee> {
    int id;
    String name;
    String surname;
    int salary;

    public Employee(int id, String name, String surname, int salary) {
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


    @Override
    public int compareTo(Employee o) {

        if(this.id == o.id){
            return o.id;
        }else if(this.id < o.id){
            return -1;
        }else{
            return 1;
        }
        // Kurzfassungen
        // int
        // return this.iad-o.id;

        // Integer
        // return this.iad.compareTo(o.id);

        // String
        // return this.name.compareTo(o.name);

        // Mehrere Datentypen
        // int res = this.name.compareTo(o.name);
        // if(res == 0){
        //  res = this.surname.compareTo(o.surname);
        // }
        // return res;
    }
}
