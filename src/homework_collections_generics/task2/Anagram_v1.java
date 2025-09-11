package homework_collections_generics.task2;

/* Код читает две строки. Удаляет все пробелы и переводит в нижний регистр для сравнения.
Проверяет длину — если разная, возвращает false. Создает мапу частот символов для первой строки.
Проходит по символам второй строки, вычитая из мапы. Если какой-то символ не встречается или количество превысило, возвращает false.
Если все counts равны нулю, строки — анаграммы (true).
 */

import java.util.*;

public class Anagram_v1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение строк
        String s = scanner.nextLine();
        String t = scanner.nextLine();

        // Проверка
        boolean result = isAnagram(s, t);
        System.out.println(result);

        scanner.close();
    }

    public static boolean isAnagram(String s, String t) {
        // Приводим строки к нижнему регистру и удаляем все пробелы
        String cleanS = s.replaceAll("\\s+", "").toLowerCase();
        String cleanT = t.replaceAll("\\s+", "").toLowerCase();

        // Проверяем длину
        if (cleanS.length() != cleanT.length()) {
            return false;
        }

        // Создаем мапу частот для первой строки
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : cleanS.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Проверяем вторую строку по той же мапе
        for (char c : cleanT.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                return false;
            }
            charCount.put(c, charCount.get(c) - 1);
        }

        // Если все counts равны нулю, это анаграмма
        for (int count : charCount.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}