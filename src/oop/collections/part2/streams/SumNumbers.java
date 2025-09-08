package oop.collections.part2.streams;

import java.util.stream.IntStream;

// сумма четных чисел в промежутке от 1 до 100 включительно
public class SumNumbers {
    public static void main(String[] args) {
        System.out.println(
                IntStream.range(1, 101)
                        .filter(i -> i % 2 == 0)
//                        .sum()
                        .reduce(0, Integer::sum)

        );
    }
}