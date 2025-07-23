package Java_RTK;

import java.util.Arrays;
import java.util.Scanner;

public class SortLetters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Создаем сканер для чтения входных данных
        String input = sc.nextLine(); // Читаем строку с входного потока

        // Разделяем строку по пробелу, получая два слова
        String[] words = input.split(" ");

        // Обработка каждого слова
        for (int i = 0; i < words.length; i++) {
            String lowerWord = words[i].toLowerCase(); // Переводим слово в нижний регистр
            char[] letters = lowerWord.toCharArray(); // Преобразуем слово в массив символов

            Arrays.sort(letters); // Сортируем массив букв по алфавиту

            // Создаем строку из отсортированных букв
            words[i] = new String(letters);
        }

        // Выводим результат — два отсортированных слова через пробел
        System.out.println(words[0] + " " + words[1]);

        sc.close(); // Закрываем сканер
    }
}