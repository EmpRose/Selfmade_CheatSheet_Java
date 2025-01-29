package search;

import Klassen.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {

        // Beispiel an einer ArrayList

        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(-3);
        arrayList.add(8);
        arrayList.add(12);
        arrayList.add(-8);
        arrayList.add(0);
        arrayList.add(5);
        arrayList.add(10);
        arrayList.add(1);
        arrayList.add(150);
        arrayList.add(-30);
        arrayList.add(19);


        // Ohne zu Sortieren, wird das gesuchte Element nicht gefunden werden können!
        int index1 = Collections.binarySearch(arrayList, 12);
        System.out.println(index1);
        System.out.println("____________________");

        // Nach der Sortierung, wird das Element gefunden.
        Collections.sort(arrayList); //.reverse = sortiert die Liste rückwärts // .shuffle = vermischt die Elemente
        int index2 = Collections.binarySearch(arrayList, 150);
        System.out.println(index2);
        System.out.println("____________________");

        // Beispiel mit Objekten

        Employee emp1 = new Employee(100,"Zaur",12345);
        Employee emp2 = new Employee(15,"Ivan",6542);
        Employee emp3 = new Employee(123,"Petr",8542);
        Employee emp4 = new Employee(15,"Mariya",5678);
        Employee emp5 = new Employee(182,"Kolya",125);
        Employee emp6 = new Employee(15,"Sasha",9874);
        Employee emp7 = new Employee(250,"Elena",1579);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);
        employeeList.add(emp5);
        employeeList.add(emp6);
        employeeList.add(emp7);

        //Unsortiert
        System.out.println(employeeList);
        // Sortiert (Mit Comparable<Employee> ID, Name
        Collections.sort(employeeList);
        System.out.println(employeeList);
        System.out.println("____________________");

        int index3 = Collections.binarySearch(employeeList,new Employee(182,"Kolya",125));
        System.out.println(index3);


        // Beispiel am Array
        int[] array = {-3,8,12,-8,0,5,10,1,150,-30,19};
        System.out.println(Arrays.toString(array));
        System.out.println("____________________");

        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("____________________");

        int index4 = Arrays.binarySearch(array,150);
        System.out.println(index4);



    }
}
