package NestedClasses.InnerClass;

public class Car {


    String color;
    int doorCount;
    Engine engine;


    public Car(String color, int doorCount) {
        this.color = color;
        this.doorCount = doorCount;
        //this.engine = this.new Engine(horsePower);
    }

    public void setEngine(Engine engine){
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

    public class Engine{
        private int horsePower;

        public Engine(int horsePower) {
            this.horsePower = horsePower;
        }

        @Override
        public String toString() {
            return "My Engine{" +
                    "horsePower=" + horsePower +
                    '}';
        }
    }
}

class Test{
    public static void main(String[] args) {
        // Objecte der äußeren Klasse -> darauf Objecte der inneren Klasse (gängige Reihenfolge)
        Car car = new Car ("black",4);
        Car.Engine engine = car.new Engine (450);
        car.setEngine(engine);

        System.out.println(car);

        // Bei der gleichzeitigen Erstellung, entsteht ein Object an Stelle von zweien.
        Car.Engine yellowCar = new Car("yellow",4).new Engine(130);
        System.out.println();
    }
}




