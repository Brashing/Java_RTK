package Java_RTK;

import java.util.Scanner;

public class Symbol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Создаем сканер для чтения входных данных
//        System.out.print("Введите символы '>', '<' или '-' в любой последовательности: ");
        String input = scanner.nextLine(); // Читаем строку из входного потока
        int count = 0; // Переменная для подсчета стрел
        int length = input.length(); // Длина строки
//        System.out.println("Введено символов: " + length);

        // Проходим по строке, за исключением последних 4 символов,
        // поскольку ищем подстроки длиной 5 символов
        for (int i = 0; i <= length - 5; i++) {
            String sub = input.substring(i, i + 5); // Вырезаем текущую подстроку длиной 5 символов

            // Проверяем, совпадает ли подстрока с одним из вариантов стрел
            if (sub.equals(">>-->") || sub.equals("<--<<")) {
                count++; // Если совпадает, увеличиваем счетчик
            }
        }
//        System.out.println("Символы содержат стрел: " + count); // Выводим итоговое число стрел
        System.out.println(count); // Выводим итоговое число стрел
        scanner.close(); // Закрываем сканер>
    }
}
