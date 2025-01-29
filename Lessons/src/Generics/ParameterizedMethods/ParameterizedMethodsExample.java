package Generics.ParameterizedMethods;

public class ParameterizedMethodsExample {
    public static void main(String[] args) {

        Integer[] array = {2,4,6,8,10};
        String[] strings = {"one","two","three","four"};

        Utility util1 = new Utility();
        util1.printArray(array);
        util1.printArray(strings);

    }
}

class Utility {
    //Par.Meth. mit generischem Typ T
    public <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}
