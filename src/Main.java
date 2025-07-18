import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ваше имя:");
        String name = sc.nextLine();
        System.out.println("Привет, " + name + "!");
    }
}