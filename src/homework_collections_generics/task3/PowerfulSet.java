package homework_collections_generics.task3;

import java.util.HashSet;
import java.util.Set;

public class PowerfulSet {
    // Возвращает пересечение двух наборов
    public <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    // Возвращает объединение двух наборов
    public <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    // Возвращает разницу: элементы первого набора, без тех, которые находятся также и во втором наборе
    public <T> Set<T> relativeComplement(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.removeAll(set2);
        return result;
    }
}