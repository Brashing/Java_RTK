package Java_RTK;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Создаем первый телевизор с помощью конструктора
        Television tv1 = new Television("Samsung", 55, false,20);
        // Создаем второй телевизор
        Television tv2 = new Television("LG", 65, true, 50);

        // Ввод параметров для третьего телевизора с клавиатуры
        System.out.println("Введите бренд:");
        String brand = scanner.nextLine();

        System.out.println("Введите размер экрана в дюймах:");
        int size = scanner.nextInt();

        System.out.println("Включить телевизор? (true/false):");
        boolean isOn = scanner.nextBoolean();

        System.out.println("Введите громкость (0-100):");
        int volume = scanner.nextInt();

        // Создаем третий телевизор с введенными параметрами
        Television tv3 = new Television(brand, size, isOn, volume);

        // Создаем четвертый телевизор со случайными параметрами
        String[] brands = {"Sony", "Philips", "Panasonic", "Toshiba"};
        String randomBrand = brands[random.nextInt(brands.length)];
        int randomSize = 32 + random.nextInt(69); // 32-100 дюймов
        boolean randomOn = random.nextBoolean();
        int randomVolume = random.nextInt(101); // 0-100

        Television tv4 = new Television(randomBrand, randomSize, randomOn, randomVolume);

        // Вывод информации о всех телевизорах
        System.out.println("\nСозданные телевизоры:");
        System.out.println(tv1);
        System.out.println(tv2);
        System.out.println(tv3);
        System.out.println(tv4);

        // Демонстрация работы методов управления
        System.out.println("\nДемонстрация управления:");
        tv4.turnOn();
        tv4.increaseVolume();
        tv4.decreaseVolume();
        tv4.turnOff();

        scanner.close();
    }
}
