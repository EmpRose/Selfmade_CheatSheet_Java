package Generics.ParameterizedClass;

public class ParamiterizedClassExample {
    public static void main(String[] args) {

        OneValue<String> val1 = new OneValue<>("Greetings!");
        System.out.println(val1.getValue());

        OneValue<Integer> val2 = new OneValue<>(32);
        System.out.println(val2.getValue());

    }
}

class OneValue<Thing> {
    private Thing value;

    public OneValue(Thing value) {
        this.value = value;
    }

    public Thing getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "OneValue{" +
                "value=" + value +
                '}';
    }
}

// Generics-Klasse, die nur "Nummern" aufnimmt. Integer, Double, Float
// JVM greift daher nicht auf "Object" sondern auf "Number" zu.
// JVM = Java Virtual Machine
class Info<T extends Number>{ // <T exntends Number&Interface1&Interface2> (& = implements

}
