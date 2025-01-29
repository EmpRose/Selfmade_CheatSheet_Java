package NestedClasses.AnonymousClass;

public class AnonymousClass {
    private int x = 5;

    public static void main(String[] args) {
        // Die anonyme Klasse, hat auch Zugriff auf die Elemente der außen Klasse
        Math m = new Math() {
            @Override
            public int doOperation(int a, int b) {
                AnonymousClass ac = new AnonymousClass();
                return a+b+ac.x;
            }
        };
        System.out.println(m.doOperation(3,6));

        //Erstellt ein Object einer anonymen Klasse, dass man voraussichtlich einmal gebraucht.
        Math m2 = new Math(){
            @Override
            public int doOperation(int a, int b) {
                return a*b;
            }
        };
        System.out.println(m2.doOperation(3,6));
    }

}

// Ob Klasse oder Interface, ist für die Nutzung der anonymen Klasse, nicht relevant
// Der Begriff "AnonymousInterface" existiert jedoch nicht.
interface Math{
    int doOperation (int a, int b);
}


