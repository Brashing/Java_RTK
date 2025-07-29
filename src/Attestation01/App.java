package Attestation01;

import java.util.*;
import static Attestation01.Person.readInt;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод покупателей
        List<Person> persons = new ArrayList<>();
        System.out.println("Введите количество покупателей:");
        int numPersons = readInt(scanner);
        for (int i = 0; i < numPersons; i++) {
            String name;
            while (true) {
                System.out.println("Введите имя покупателя №" + (i + 1) + " (от 3 символов):");
                name = scanner.nextLine().trim();
                if (name.isEmpty()) {
                    System.out.println("Имя не может быть пустым");
                } else if (name.length() < 3) {
                    System.out.println("Имя не может быть короче 3 символов");
//                    System.exit(0); // завершение программы
                } else {
                    break;
                }
            }

            int cash;
            while (true) {
                System.out.println("Введите сумму денег, которой обладает " + name + ":");
                String input = scanner.nextLine().trim();
                try {
                    cash = Integer.parseInt(input);
                    if (cash < 0) {
                        System.out.println("Деньги не могут быть отрицательными");
//                        System.exit(0); // завершение программы
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный ввод, попробуйте снова");
                }
            }

            persons.add(new Person(name, cash, new Product[0]));
        }

        // Ввод продуктов
        List<Product> products = new ArrayList<>();
        System.out.println("Введите количество продуктов:");
        int numProducts = readInt(scanner);
        for (int i = 0; i < numProducts; i++) {
            System.out.println("Введите название продукта №" + (i + 1) + ":");
            String prodName = scanner.nextLine().trim();

            int price;
            while (true) {
                System.out.println("Введите стоимость продукта:");
                String priceInput = scanner.nextLine().trim();
                try {
                    price = Integer.parseInt(priceInput);
                    if (price < 0) {
                        System.out.println("Стоимость не может быть отрицательной");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный ввод, попробуйте снова");
                }
            }
            products.add(new Product(prodName, price));
        }

        // Ввод покупок по именам
        System.out.println("Вводите покупки. Для завершения введите 'END'.");
//        boolean anyPurchases = false;
        while (true) {
            System.out.println("Введите имя покупателя:");
            String nameBuyer = scanner.nextLine().trim();
            if (nameBuyer.equalsIgnoreCase("END")) {
                break;
            }

            // Находим покупателя
            Person person = null;
            for (Person p : persons) {
                if (p.getNamePerson().equalsIgnoreCase(nameBuyer)) {
                    person = p;
                    break;
                }
            }
            if (person == null) {
                System.out.println("Покупатель не найден, попробуйте снова.");
                continue;
            }

            System.out.println("Введите название продукта для покупки:");
            String productName = scanner.nextLine().trim();

            // Поиск продукта по названию (чтобы быть нечувствительным к регистру)
            Product toBuy = null;
            for (Product p : products) {
                if (p.getTitle().equalsIgnoreCase(productName)) {
                    toBuy = p;
                    break;
                }
            }

            if (toBuy == null) {
                System.out.println("Продукт не найден в списке. Попробуйте еще раз.");
                // Можете повторять ввод или переходить к следующему шагу
            } else {
                // Производите покупку
                boolean success = person.buyProduct(toBuy);
                if (success) {
                    System.out.println(person.getNamePerson() + " купил " + toBuy.getTitle());
                } else {
                    System.out.println(person.getNamePerson() + " не может позволить себе " + toBuy.getTitle());
                }
            }
        }

            // Итог: кто что купил или ничего
            System.out.println("\nИТОГ:");
            for (Person p : persons) {
                StringBuilder sb = new StringBuilder();
                sb.append(p.getNamePerson()).append(" - ");
                if (p.getProductPackage().length == 0) {
                    sb.append("Ничего не купил");
                } else {
                    for (int i = 0; i < p.getProductPackage().length; i++) {
                        sb.append(p.getProductPackage()[i].getTitle());
                        if (i < p.getProductPackage().length - 1) {
                            sb.append(", ");
                        }
                    }
                }
                System.out.println(sb);
            }
            scanner.close();
        }
    }