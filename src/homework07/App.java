package homework07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод покупателей
        List<Person> persons = new ArrayList<>();
        System.out.print("Введите количество покупателей: ");
        int numPersons = readInt(scanner);
        for (int i = 0; i < numPersons; i++) {
            String name;
            while (true) {
                System.out.print("Введите имя покупателя №" + (i + 1) + " (от 3 символов): ");
                name = scanner.nextLine().trim();
                if (name.isEmpty()) {
                    System.out.println("Имя не может быть пустым");
                } else if (name.length() < 3) {
                    System.out.println("Имя не может быть короче 3 символов");
                } else {
                    break;
                }
            }

            int cash;
            while (true) {
                System.out.print("Введите сумму денег, которой обладает " + name + ": ");
                String input = scanner.nextLine().trim();
                try {
                    cash = Integer.parseInt(input);
                    if (cash < 0) {
                        System.out.println("Деньги не могут быть отрицательными");
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
        System.out.print("Введите количество продуктов: ");
        int numProducts = readInt(scanner);
        for (int i = 0; i < numProducts; i++) {
            String prodName;
            while (true) {
                System.out.print("Введите название продукта №" + (i + 1) + ": ");
                prodName = scanner.nextLine().trim();
                if (prodName.isEmpty()) {
                    System.out.println("Название не может быть пустым, попробуйте снова.");
                    continue;
                }
                if (prodName.length() < 3) {
                    System.out.println("Название должно быть не менее 3 символов, попробуйте снова.");
                    continue;
                }
                if (prodName.matches("\\d+")) {
                    System.out.println("Название не может содержать только цифры, попробуйте снова.");
                    continue;
                }
                break;
            }

            // Проверяем, есть ли такой продукт в списке
            Product existingProduct = null;
            for (Product p : products) {
                if (p.getTitle().equalsIgnoreCase(prodName)) {
                    existingProduct = p;
                    break;
                }
            }

            int price;
            if (existingProduct != null) {
                // Продукт с таким названием есть — используем его цену
                price = existingProduct.getValue();
                System.out.println("Этот продукт уже есть. Его стоимость: " + price);
            } else {
                // Новая цена — запрашиваем у пользователя
                while (true) {
                    System.out.print("Введите стоимость продукта: ");
                    String priceInput = scanner.nextLine().trim();
                    try {
                        price = Integer.parseInt(priceInput);
                        if (price <= 0) {
                            System.out.println("Стоимость должна быть положительной");
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Некорректный ввод, попробуйте снова");
                    }
                }
                // Добавляем новый продукт в список
                Product newProduct = new Product(prodName, price);
                products.add(newProduct);
            }
        }

        // Ввод продукта со скидкой
        System.out.print("Добавить продукт со скидкой? (да/нет) ");
        String answer = scanner.nextLine().trim();
        if (answer.equalsIgnoreCase("да")) {
            boolean addingDiscount = true;
            while (addingDiscount) {
                System.out.print("Введите название продукта со скидкой: ");
                String name = scanner.nextLine().trim();

                // Проверяем есть ли такой продукт в списке
                Product existingProduct = null;
                for (Product p : products) {
                    if (p.getTitle().equalsIgnoreCase(name)) {
                        existingProduct = p;
                        break;
                    }
                }

                int price;
                if (existingProduct != null) {
                    // Если продукт уже есть в списке — используем существующую цену
                    price = existingProduct.getValue();
                    System.out.println("Этот продукт есть в списке. Его стоимость: " + price);
                } else {
                    // Если продукта нет в списке, запрашиваем цену
                    while (true) {
                        System.out.print("Введите цену продукта: ");
                        String inputPrice = scanner.nextLine().trim();
                        try {
                            price = Integer.parseInt(inputPrice);
                            if (price <= 0) {
                                System.out.println("Цена должна быть положительной");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Некорректный ввод");
                        }
                    }
                }

                // Запрашиваем процент скидки
                System.out.print("Введите процент скидки (1 - 100): ");
                int discountPercent;
                while (true) {
                    String inputPercent = scanner.nextLine().trim();
                    try {
                        discountPercent = Integer.parseInt(inputPercent);
                        if (discountPercent <= 0 || discountPercent > 100) {
                            System.out.println("Процент должен быть от 1 до 100");
                            continue;
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Некорректный ввод");
                    }
                }

                // Ввод срока действия скидки
                System.out.print("Введите дату окончания скидки в формате 'гг гг-мм-дд': ");
                String dateStr = scanner.nextLine().trim();
                LocalDate endDate;
                try {
                    endDate = LocalDate.parse(dateStr);
                    if (endDate.isBefore(LocalDate.now())) {
                        System.out.println("Дата должна быть в будущем. Попробуйте снова.");
                        System.out.print("Добавить продукт со скидкой? (да/нет) ");
                        String againAnswer = scanner.nextLine().trim();
                        if (!againAnswer.equalsIgnoreCase("да")) {
                            break; // прекращаем
                        }
                    } else {
                        // Проверяем, есть ли продукт в списке. Обновляем или добавляем в список
                        boolean productExists = false;
                        for (Product p : products) {
                            if (p.getTitle().equalsIgnoreCase(name)) {
                                productExists = true;
                                if (p instanceof DiscountProduct) {
                                    System.out.println("Обновляем скидку существующего продукта.");
                                    // Обновляем
                                    double discountMultiplier = 1 - (discountPercent / 100.0);
                                    int newPrice = (int) Math.round(p.getValue() * discountMultiplier);
                                    // Обновление объекта
                                    DiscountProduct dp = new DiscountProduct(name, newPrice, discountPercent, endDate);
                                    products.remove(p);
                                    products.add(dp);
                                } else {
                                    // Уменьшаем текущую цену на размер скидки
                                    int newPrice = p.getValue() * (100 - discountPercent) / 100;
                                    p.setValue(newPrice);
                                }
                                break;
                            }
                        }
                        if (!productExists) {
                            // Создаем новый продукт со скидкой
                            DiscountProduct dp = new DiscountProduct(name, price, discountPercent, endDate);
                            products.add(dp);
                        }
                        System.out.println("Продукт со скидкой добавлен/обновлен.");
                        System.out.print("Добавить еще? (да/нет) ");
                        String continueAnswer = scanner.nextLine().trim();
                        if (!continueAnswer.equalsIgnoreCase("да")) {
                            addingDiscount = false;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Некорректный формат даты. Попробуйте снова.");
                    System.out.println("Добавить продукт со кидкой? (да/нет)");
                    String againAnswer = scanner.nextLine().trim();
                    if (!againAnswer.equalsIgnoreCase("да")) {
                        break; // прекращение
                    }
                    // иначе повтор
                }
            }
        }

        // Ввод покупок по именам
        System.out.println("Вводите покупки. Для завершения введите 'END'.");
        while (true) {
            System.out.print("Введите имя покупателя: ");
            String nameBuyer = scanner.nextLine().trim();
            if (nameBuyer.equalsIgnoreCase("END")) {
                break;
            }

            // Находим покупателя
            Person person = null;
            for (homework07.Person p : persons) {
                if (p.getNamePerson().equalsIgnoreCase(nameBuyer)) {
                    person = p;
                    break;
                }
            }
            if (person == null) {
                System.out.println("Покупатель не найден, попробуйте снова.");
                continue;
            }

            System.out.print("Введите название продукта для покупки: ");
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

            } else {
                // Выполняем покупку
                boolean success = person.buyProduct(toBuy);
                if (success) {
                    System.out.println(person.getNamePerson() + " купил(-а) " + toBuy.getTitle());
                } else {
                    System.out.println(person.getNamePerson() + " не может позволить себе " + toBuy.getTitle());
                }
            }
        }

            // Итог: кто что купил или ничего не купил
            System.out.println("\nИТОГ:");
            for (Person p : persons) {
                StringBuilder sb = new StringBuilder();
                sb.append(p.getNamePerson()).append(" - ");
                if (p.getProductPackage().length == 0) {
                    sb.append("Ничего не купил(-а)");
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
    // вспомогательный метод
    public static int readInt(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод, попробуйте снова:");
            }
        }
    }
}