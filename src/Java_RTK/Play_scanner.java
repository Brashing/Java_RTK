package Java_RTK;

import java.util.Scanner; // Импортируем класс Scanner для ввода данных с клавиатуры

public class Play_scanner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Создаем объект Scanner для чтения пользовательского ввода

        String vasyaChoice; // Объявляем переменную для выбора Васи
        String petyaChoice; // Объявляем переменную для выбора Пети

        // Блок для ввода и проверки выбора Васи с возможностью повторного ввода
        while (true) {
            System.out.print("Вася, выбери фигуру (Камень, Ножницы, Бумага): "); // Просим Васю выбрать фигуру
            vasyaChoice = input.nextLine().trim(); // Читаем ввод и удаляем лишние пробелы по краям

            // Проверяем, что ввод соответствует допустимым значениям
            if (vasyaChoice.equalsIgnoreCase("Камень") ||
                    vasyaChoice.equalsIgnoreCase("Ножницы") ||
                    vasyaChoice.equalsIgnoreCase("Бумага")) {
                break; // Если выбор правильный, выходим из цикла
            } else {
                // Если выбор неверный, выводим сообщение и повторяем ввод
                System.out.println("Ошибка! Введено неверное значение! Попробуйте снова.");
            }
        }

        // Аналогичный блок для ввода и проверки выбора Пети
        while (true) {
            System.out.print("Петя, выбери фигуру (Камень, Ножницы, Бумага): "); // Просим Петю выбрать фигуру
            petyaChoice = input.nextLine().trim(); // Читаем ввод и удаляем пробелы

            // Проверяем, допустим ли ввод
            if (petyaChoice.equalsIgnoreCase("Камень") ||
                    petyaChoice.equalsIgnoreCase("Ножницы") ||
                    petyaChoice.equalsIgnoreCase("Бумага")) {
                break; // Если правильный ввод, выходим из цикла
            } else {
                // Если нет, выводим сообщение и запрашиваем заново
                System.out.println("Ошибка! Введено неверное значение! Попробуйте снова.");
            }
        }

        // Теперь сравниваем выборы и определяем победителя
        if (vasyaChoice.equalsIgnoreCase(petyaChoice)) {
            // Если оба выбрали одинаковую фигуру — ничья
            System.out.println("Ничья!");
        } else if (
            // Проверяем случаи, когда победитель — Вася
                (vasyaChoice.equalsIgnoreCase("Камень") && petyaChoice.equalsIgnoreCase("Ножницы")) ||
                        (vasyaChoice.equalsIgnoreCase("Ножницы") && petyaChoice.equalsIgnoreCase("Бумага")) ||
                        (vasyaChoice.equalsIgnoreCase("Бумага") && petyaChoice.equalsIgnoreCase("Камень"))
        ) {
            System.out.println("Победил Вася!"); // Вася выиграл
        } else {
            System.out.println("Победил Петя!"); // Во всех остальных случаях выиграл Петя
        }

        input.close(); // Закрываем сканер — освобождаем ресурсы
    }
}