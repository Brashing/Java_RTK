package oop.collections.part2.streams;

import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> myPlaces = List.of("Nepal, Pokhara ", "Nepal, Kathmandu ",  "India, Delhi", "USA, New York", "Africa, Nigeria");
        myPlaces.stream()
                .filter(place -> place.startsWith("Nepal"))
//                .map(place -> place.toUpperCase())
                .map(String::toUpperCase)
                .map(String::trim)
                .sorted()
                .forEach(System.out::println);
    }
}