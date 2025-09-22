package homework_collections_generics.task1;

import java.util.*;

public class UniqueElements {
    /* Объявляем публичный статический универсальный дженерик-метод, работающий с любым типом <T>.
    Этот метод принимает список любого типа и возвращает множество уникальных элементов этого списка.
    Set<T> возвращает множество элементов того же типа <T>.
    ArrayList<T> list - входящий параметр, список элементов типа <T>.
     */
    public static <T> Set<T> getUniqueElements(ArrayList<T> list) {
        // Используем HashSet для получения уникальных элементов
        return new HashSet<>(list);
    }
    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Нижний Новгород");
        cities.add("Москва");
        cities.add("Омск");
        cities.add("Томск");
        cities.add("Москва");
        cities.add("Нижний Новгород");
        cities.add("Нижний Новгород");

        Set<String> uniqueItems = getUniqueElements(cities);
        System.out.println(uniqueItems);
    }
}