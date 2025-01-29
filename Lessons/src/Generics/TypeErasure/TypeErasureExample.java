package Generics.TypeErasure;

import java.util.ArrayList;

public class TypeErasureExample {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // Ohne Generics = "Raw-Type"
        // ArrayList list = new ArrayList();


        int i = list.get(0);
        //int i = (Integer)list.get(0)

    }

    // Verschiedene Generics, werden nicht unterschieden
    /*
    // abc(Info info) - Type Erasure
    public void abc(Info<String> info ){
        String s = info.getValue();
    }
    // abc(Info info) - Type Erasure
    public void abc(Info<Integer> info ){
        Integer i = info.getValue();
    }
    */
}

class Info<Thing> {
    private Thing value;

    public Info(Thing value) {
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


// Verschiedene Generics , selbe Methode, Vererbung
/*
class Parent{
    public void abc(Info<String> info ){
        String s = info.getValue();
    }
}

class Child extends Parent{
    @Override
    public void abc(Info<Integer> info ){
        Integer i = info.getValue();
    }
}
*/
