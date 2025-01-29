package LambdaExpressions.Consumer;
import LambdaExpressions.Supplier.Vehicle;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

// Methode void accept(T t) -> gibt nichts zurück, empfängt ein Parameter

public class ConsumerExample {

    public static ArrayList<Vehicle> createThreeVehicles(Supplier<Vehicle> vehicleSupplier){
        ArrayList<Vehicle> vehicleArrayList = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            vehicleArrayList.add(vehicleSupplier.get());
        }
        return vehicleArrayList;
    }

    public static void changeVehicle(Vehicle vehicle, Consumer<Vehicle> vehicleConsumer){
        vehicleConsumer.accept(vehicle);
    }

    public static void main(String[] args) {
        ArrayList<Vehicle> garage = createThreeVehicles(() ->
                new Vehicle("Nissan Tiida","silver Metalic",1.6));
        System.out.println("Garage: " + garage);


        changeVehicle(garage.get(0),vehicle
                -> {vehicle.setColor("red");
                    vehicle.setEngine(3.0);
                    System.out.println("Vehicle was upgradet: " + vehicle);});

        System.out.println(garage);
    }


}
