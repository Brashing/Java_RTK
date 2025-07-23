import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Создаем объект Scanner для чтения данных с клавиатуры

        System.out.println("Введите ваше имя: "); // Просим пользователя ввести свое имя
        String name = sc.nextLine(); // Считываем имя пользователя

        // Приветствуем пользователя
        System.out.println("Привет, " + name + "!");
    }
}