package homework_collections_generics.task3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        PowerfulSet ps = new PowerfulSet();

        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(0, 1, 2, 4));

        System.out.println("Пересечение: " + ps.intersection(set1, set2));
        System.out.println("Объединение: " + ps.union(set1, set2));
        System.out.println("Разность: " + ps.relativeComplement(set1, set2));
    }
}
