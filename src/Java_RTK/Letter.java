package Java_RTK;

import java.util.Scanner; // Импортируем класс Scanner

public class Letter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Создаем объект Scanner для чтения ввода с клавиатуры
        String keyboard = "qwertyuiopasdfghjklzxcvbnm"; // Строка с порядком английских букв на клавиатуре

        while (true) {
            System.out.print("Введите английскую букву с клавиатуры: ");
            char inputChar = scanner.nextLine().charAt(0); // Читаем символ
            int index = keyboard.indexOf(inputChar); // Ищем индекс символа

            if (index != -1) {
                int leftIndex = (index - 1 + keyboard.length()) % keyboard.length(); // Вычисляем индекс слева с учетом замкнутости
                // Выражение (index - 1 + длина) % длина обеспечивает "замкнутость" клавиатуры:
                // если index=0, то (0 - 1 + 26) % 26 = 25, то есть выполняется переход к последнему символу
                System.out.println("На клавиатуре слева от буквы " + inputChar + " располагается буква " + keyboard.charAt(leftIndex) + "."); // Выводим результат
                break; // Завершаем цикл после успешного ввода
            } else {
                System.out.println("Введена некорректная буква! Попробуйте снова. Проверьте раскладку клавиатуры."); // Выводим сообщение и просим повторить ввод
            }
        }
        scanner.close(); // Закрываем Scanner
    }
}
