package Generics.ParameterizedClass;

public class ParamiterezedClassExample2 {
    public static void main(String[] args) {
        Pair<String,Integer> pair1 = new Pair<>("Hi, Dude! ", 20);
        System.out.println(pair1.getFirstValue() + pair1.getSecondValue());

        Pair<Integer,Double> pair2 = new Pair<>(168, 3.14);
        System.out.println(pair2.getFirstValue() + " : " +  pair2.getSecondValue());

        OtherPair<Integer> pair3 = new OtherPair<>(3,7);
        System.out.println(pair3.getValue1()+pair3.getValue2());
    }
}

class Pair <V1,V2>{
    private V1 value1;
    private V2 value2;

    public Pair(V1 value1, V2 value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V1 getFirstValue() {
        return value1;
    }

    public V2 getSecondValue() {
        return value2;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                '}';
    }
}



class OtherPair <Thing>{
    private Thing value1;
    private Thing value2;

    public OtherPair(Thing value1, Thing value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public Thing getValue1() {
        return value1;
    }

    public Thing getValue2() {
        return value2;
    }
}
