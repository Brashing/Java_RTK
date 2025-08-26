/*Промежуточная аттестация Модуль 1 «Введение в разработку/Введение в Java»
Формулировка задания:
Необходимо реализовать приложение, принимающее пользователей, продуктов и обрабатывающее покупку пользователя.
Подробное описание функционала приложения
1. Создать классы Покупатель (Person) и Продукт (Product).
Характеристики Покупателя: имя, сумма денег и пакет с продуктами (массив объектов типа Продукт). Имя не может быть пустой строкой и не может быть короче 3 символов. Деньги не могут быть отрицательным числом.
Если Покупатель может позволить себе Продукт, то Продукт добавляется в пакет. Если у Покупателя недостаточно денег, то добавление не происходит.
Характеристики Продукта: название и стоимость. Название продукта не может быть пустой строкой, оно должно быть. Стоимость продукта не может быть отрицательным числом.
2. Поля в классах должны быть private, доступ к полям осуществляется через геттеры и сеттеры или конструктор класса.
3. В классах переопределены методы toString(), equals(), hashcode().
4. Создать в классе App метод main и проверить работу приложения.
Данные Покупателей и Продукты вводятся с клавиатуры, для считывания данных потребуется использовать класс Scanner и его метод nextLine().
Продукты в цикле выбираются покупателями по очереди и, пока не введено слово END, наполняется пакет.
5. Обработать следующие ситуации:
а. Если покупатель не может позволить себе продукт, то напечатайте соответствующее сообщение ("[Имя человека] не может позволить себе [Название продукта]").
б. Если ничего не куплено, выведите имя человека, за которым следует "Ничего не куплено".
в. В случае неверного ввода - сообщение: "Деньги не могут быть отрицательными", пустого имени - сообщение: "Имя не может быть пустым" или длина имени менее 3 символов – сообщение: "Имя не может быть короче 3 символов".
Программа реализуется в отдельной ветке git attestation/attestation01. При сохранении состояния программы (коммиты) пишется сообщение с описанием хода работы по задаче.
В корне папки с программой должен быть файл .gitignore.
Программа локально коммитится и публикуется в репозиторий GitHub на проверку.

Тестовые данные 1:
Павел Андреевич = 10000; Анна
Петровна = 2000; Борис = 10
Хлеб = 40; Молоко = 60; Торт = 1000;
Кофе растворимый = 879; Масло = 150
Павел Андреевич - Хлеб
Павел Андреевич - Масло
Анна Петровна - Кофе растворимый
Анна Петровна - Молоко
Анна Петровна - Молоко
Анна Петровна - Молоко
Анна Петровна - Торт
Борис - Торт
Павел Андреевич - Торт
END

Ожидаемый результат 1:
Павел Андреевич купил Хлеб
Павел Андреевич  купил Масло
Анна Петровна  купил Кофе
растворимый
Анна Петровна  купил Молоко
Анна Петровна  купил Молоко
Анна Петровна  купил Молоко
Анна Петровна  не может позволить себе Торт
Борис  не может позволить себе Торт
Павел Андреевич купил Торт
Павел Андреевич - Хлеб, Масло, Торт
Анна Петровна - Кофе растворимый,
Молоко, Молоко, Молоко
Борис -  Ничего не куплено

Тестовые данные 2:
Женя = 0;
Мороженое = 200
Женя - Мороженое
Ожидаемый результат 2:
Женя не может позволить себе Мороженое
Женя -  Ничего не куплено

Тестовые данные 3:
Света = -3
Ожидаемый результат 3:
Деньги не могут быть отрицательными

Тестовые данные 4:
Фа = 100
Ожидаемый результат 4:
Имя не может быть короче 3 символов

Тестовые данные вводятся по очереди, сначала проверяется успешный кейс, потом не успешные, для неуспешных достаточно получить сообщение о невозможности покупки или ошибке валидации. После данного сообщения, сделать скриншот и завершить программу.
Планируемый результат:
1. Ссылка на программу в репозитории GitHub;
2. Отчёт со скринами выполнения задач - постановка задачи, код задачи и результат в консоли Intellij Idea.

Перечень инструментов, необходимых для реализации деятельности:
Персональный компьютер, JDK 17/21 (либо OpenJDK 17/21), Intellij Idea для разработки на Java, GIT. */

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