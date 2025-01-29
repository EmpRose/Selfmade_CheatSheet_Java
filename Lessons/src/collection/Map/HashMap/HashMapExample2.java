package collection.Map.HashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample2 {
    public static void main(String[] args) {
        // 16 capacity 0.75 load factor = 16*0.75 = 12
        // sobald 12 Index-Elemente genutzt werden, wird das Array auf 32 verdoppelt
        // in einem solchem Fall, wird das "re-hashing" erzeugt
        // Alle Elemente erhalten neue Index-Werte (Das Array nimmt mehr Arbeitsspeicher - dafür weniger LL und schnellerer Zugriff)
        Map<Integer, String> map = new HashMap<>(16, 0.75f);


    }
}
