package LambdaExpressions;

public class Test2 {
    static void def(I i){
        System.out.println(i.abc("privet"));
    }
    static void def2(anInterface i) {
        System.out.println(i.abc());
    }

    public static void main(String[] args) {

        def((String str) -> {return str.length();});
        def(s -> s.length());

        def2(()-> 19);
    }


}

interface I{
    int abc(String s);
}

interface anInterface {
 int abc ();
        }