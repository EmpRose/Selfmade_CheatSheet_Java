package NestedClasses.LocalInnerClass;

public class LocalInnerExample {
    public static void main(String[] args) {
        Math math = new Math();
        math.getResult(2,4);
    }
}

class Math {

    public void getResult(final int delimoe, final int delitel) {
        // Die Klasse "Divide" ist nur in der Methode "getResult" sichtbar.
        // Kann nicht static sein
        // Kann private Elemente der äußeren Klasse ansprechen.
        class Divide {

            public int getDelimoe() {
                return delimoe;
            }

            public int getDelitel() {
                return delitel;
            }

            public int getChastnoe() {
                return delimoe / delitel;
            }

            public int getOstatok() {
                return delimoe % delitel;
            }
        }

        Divide delenie = new Divide();

        System.out.println("Delimoe = " + delenie.getDelimoe());
        System.out.println("Delitel = " + delenie.getDelitel());
        System.out.println("Chastnoe = " + delenie.getChastnoe());
        System.out.println("Ostatok = " + delenie.getOstatok());
    }
}

