package LambdaExpressions.Function; // Function <T,R> (Type , Returntype) // Hintergrund - Kann ein Datentyp annehmen und ein anderes zurückgeben

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Schoolar sc1 = new Schoolar("Ivan", "m", 22, 3, 8.3);
        Schoolar sc2 = new Schoolar("Nikolay", "m", 28, 2, 6.4);
        Schoolar sc3 = new Schoolar("Elena", "f", 19, 1, 8.9);
        Schoolar sc4 = new Schoolar("Petr", "m", 35, 4, 7.0);
        Schoolar sc5 = new Schoolar("Mariya", "f", 23, 3, 9.1);


        ArrayList<Schoolar> schoolars = new ArrayList<>();
        schoolars.add(sc1);
        schoolars.add(sc2);
        schoolars.add(sc3);
        schoolars.add(sc4);
        schoolars.add(sc5);

        // Hinweis: Weitere Beispiele erstellen.
        // Hintergrund - Kann ein Datentyp annehmen und ein anderes zurückgeben
        // Function<Schoolar,Double> f = sc6 -> 5.5; -> Kurzes Schreibbeispiel
        double res = avgOfSomething(schoolars, schoolar -> (double)schoolar.age);
        System.out.println(res);

    }

    // Hinweis: Weitere Beispiele erstellen.
    private static double avgOfSomething(List<Schoolar> list, Function<Schoolar,Double> f){
        double result = 0;
        for (Schoolar sc: list){
            result += f.apply(sc);
        }
        result = result /list.size();
        return result;
    }

}


