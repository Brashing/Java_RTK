package Java_RTK;

import java.io.PrintStream;
import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ваше имя: ");
        String name = scanner.nextLine();

        System.out.println("Введите ваш возраст: ");
        int age = scanner.nextInt();

        System.out.println("Привет, " + name + "!" + "Твой возраст: " + age + ".");
    }
}
