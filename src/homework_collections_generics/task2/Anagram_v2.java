package homework_collections_generics.task2;

/* Удаляет пробелы, переводит в нижний регистр. Преобразует строки в массивы символов.
Сортирует оба массива. Сравнивает отсортированные массивы — если равны, то строки — анаграммы.
 */

import java.util.*;

public class Anagram_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое слово или фразу: ");
        String s = scanner.nextLine();
        System.out.print("Введите второе слово или фразу: ");
        String t = scanner.nextLine();
        boolean result = isAnagram(s, t);
        System.out.println("Анаграмма? " + result);
        scanner.close();
    }

    public static boolean isAnagram(String s, String t) {
        // Приводим к нижнему регистру, удаляем все пробелы
        String sClean = s.replaceAll("\\s+", "").toLowerCase();
        String tClean = t.replaceAll("\\s+", "").toLowerCase();

        // Сортируем символы и сравниваем строки
        char[] arrS = sClean.toCharArray();
        char[] arrT = tClean.toCharArray();
        Arrays.sort(arrS);
        Arrays.sort(arrT);
        return Arrays.equals(arrS, arrT);
    }
}