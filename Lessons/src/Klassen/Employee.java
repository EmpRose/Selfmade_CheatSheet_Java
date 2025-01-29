package Klassen;

public class Employee implements Comparable<Employee>{
    int id;
    String name;
    int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;

    }

    @Override
    public String toString() {
        return "Employee: {" +
                "ID: " + id +
                " Name: " + name +
                " Salary: " + salary + "}";
    }

    @Override
    public int compareTo(Employee anotherEmp) {
        int result = this.id - anotherEmp.id;
        if(result == 0){
            result = this.name.compareTo(anotherEmp.name);
        }
        return result;
    }
}
