package Java_RTK;

import java.util.Scanner;

public class Letter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String keyboard = "qwertyuiopasdfghjklzxcvbnm";

        while (true) {
            System.out.print("Введите английскую букву с клавиатуры: ");
            char inputChar = scanner.nextLine().charAt(0);
            int index = keyboard.indexOf(inputChar);
            if (index != -1) {
                int leftIndex = (index - 1 + keyboard.length()) % keyboard.length();
                System.out.println("На клавиатуре слева от буквы " + inputChar + " располагается буква " + keyboard.charAt(leftIndex) + ".");
                break;
            } else {
                System.out.println("Введена некорректная буква! Попробуйте снова.");
            }
        }
        scanner.close();
    }
}
