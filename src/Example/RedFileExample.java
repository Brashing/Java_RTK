package Example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RedFileExample {
    public static void main(String[] args) {
        try {
            File file = new File("D:\\disabled_custom_plugins.txt");
            Scanner fileScanner = new Scanner(file);

            while(fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }

    }
}

