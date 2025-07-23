package Java_RTK;

import java.util.Random;

public class Play_random {
    public static void main(String[] args) {
        Random random = new Random();

        String[] figurName = { "Камень", "Ножницы", "Бумага"};

        String vasyaChoice = figurName[random.nextInt(figurName.length)];
        String petyaChoice = figurName[random.nextInt(figurName.length)];

        System.out.println("Вася выбрал: " + vasyaChoice);
        System.out.println("Петя выбрал: " + petyaChoice);

        if (vasyaChoice.equals(petyaChoice)) {
            System.out.println("Ничья!");
        } else if (
            (vasyaChoice.equals("Камень") && petyaChoice.equals("Ножницы")) ||
                    (vasyaChoice.equals("Ножницы") && petyaChoice.equals("Бумага")) ||
                    (vasyaChoice.equals("Бумага") && petyaChoice.equals("Камень"))
        ) {
            System.out.println("Победил Вася!");
        } else {
            System.out.println("Победил Петя!");
        }
    }
}