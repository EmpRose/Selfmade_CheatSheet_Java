package LambdaExpressions.Supplier;

import java.util.ArrayList;
import java.util.function.Supplier;

//Interface Supplier -> verfügt nur über die abstracte Methode "T get()"
public class SupplierExample {


    public static ArrayList<Vehicle> createThreeVehicles(Supplier<Vehicle> vehicleSupplier){
        ArrayList<Vehicle> val = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            val.add(vehicleSupplier.get());
        }
        return val;
    }

    public static void main(String[] args) {
        ArrayList<Vehicle> garage = createThreeVehicles(() ->
                new Vehicle("Nissan Tilda","silver Metalic",1.6));
        System.out.println("Garage: " + garage);
    }

}


// Unterschiedliche Modelle von vehicle erstelle.
/*
Diese Variante ist noch nicht ausgeklügelt und mir gefällt die Umsetzung nicht.
Hinweis: Überarbeiten


public class SupplierExample {

    public static ArrayList<Vehicle> createThreeVehicles(Supplier<Vehicle> vehicleSupplier) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            vehicles.add(vehicleSupplier.get());
        }
        return vehicles;
    }

    public static void main(String[] args) {
        // Indexbasiertes Erstellen von Fahrzeugen
        int[] index = {0}; // Verwenden Sie ein Array als Workaround für Lambda (mutable int)

        ArrayList<Vehicle> garage = createThreeVehicles(() -> {
            index[0]++;
            switch (index[0]) {
                case 1:
                    return new Vehicle("Nissan Tiida", "Silver Metallic", 1.6);
                case 2:
                    return new Vehicle("Mazda RX7", "Red", 2.0);
                case 3:
                    return new Vehicle("Benz", "Black", 3.0);
                default:
                    throw new IllegalStateException("Unexpected value: " + index[0]);
            }
        });

        System.out.println("Garage: " + garage);
    }
}
 */
