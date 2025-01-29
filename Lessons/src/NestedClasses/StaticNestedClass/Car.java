package NestedClasses.StaticNestedClass;

public class Car {


    String color;
    int doorCount;
    Engine engine;
    // Zugriff auf private und/ oder static Variable in der inneren Klasse
    // private static int a;

    public Car(String color, int doorCount, Engine engine) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "My Vehicle: {" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }

    void method(){
        System.out.println(Engine.countOfObjects);
        Engine e = new Engine(200);
        System.out.println(e.horsePower);
    }

    // Klasse als statisches inneres Element der außen Klasse
    public static class Engine{
        private int horsePower;
        static int countOfObjects;


        public Engine(int horsePower) {

            // static - Zugriff gewährt
            // System.out.println(a);
            // nicht "static" - kein Zugriff
            // System.out.println(doorCount);
            this.horsePower = horsePower;
            countOfObjects++;
        }


        @Override
        public String toString() {
            return "My Engine{" +
                    "horsePower=" + horsePower +
                    '}';
        }
    }
    // Auch Interfaces sind realisierbar
    interface I {

    }
}


class Test{
    public static void main(String[] args) {
        // Die statische innere Klasse, kann durch die äußere angesprochen werden.
        Car.Engine e = new Car.Engine(256);
        System.out.println(e);

        Car car = new Car("Red",2,e);
        System.out.println(car);

        // Die innere Klasse, muss durch die äußere angesprochen werden
        // nicht durch ein bestehendes Object
        //Vehicle.Engine engine2 = new car.Engine(150);
    }
}

