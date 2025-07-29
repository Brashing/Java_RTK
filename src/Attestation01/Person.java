package Attestation01;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Person {
    // Поля класса
    private String namePerson;
    private int cash;
    private Product[] productPackage;

    // Конструктор
    public Person(String namePerson, int cash, Product[] productPackage) {
        // Проверка имени
        if (namePerson == null || namePerson.trim().length() < 3) {
            throw new IllegalArgumentException("Имя не может быть пустым или короче 3 символов!");
        }
        // Проверка суммы
        if (cash < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными!");
        }
        this.namePerson = namePerson;
        this.cash = cash;

        // Проверка массивa продуктов, чтобы он не был пустым
        if (productPackage == null) {
            this.productPackage = new Product[0];
        } else {
            this.productPackage = productPackage;
        }
    }

    // Геттеры и сеттеры

    public String getNamePerson() { return namePerson;
    }

    public void setNamePerson(String namePerson) {
        if (namePerson == null || namePerson.trim().length() < 3) {
            throw new IllegalArgumentException("Имя не может быть пустым или короче 3 символов!");
        }
        this.namePerson = namePerson;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        if (cash < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
        this.cash = cash;
    }

    public Product[] getProductPackage() {
        return productPackage;
    }

    public void setProductPackage(Product[] productPackage) {
        if (productPackage == null) {
            this.productPackage = new Product[0]; // или можно оставить null
        } else {
            this.productPackage = productPackage;
        }
    }

    // Метод покупки продукта
    public boolean buyProduct(Product product) {
        if (product == null) {
            return false;
        }
        if (this.cash >= product.getValue()) {
            this.cash -= product.getValue(); // списываем деньги
            this.productPackage = addProductToPackage(product);
            return true; // успешно куплено
        } else {
            return false; // недостаточно денег
        }
    }

    // Вспомогательный метод добавления продукта в пакет покупателя
    private Product[] addProductToPackage(Product product) {
        Product[] newPackage = Arrays.copyOf(this.productPackage, this.productPackage.length + 1);
        newPackage[newPackage.length - 1] = product;
        return newPackage;
    }

    static int readInt(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Попробуйте снова:");
            }
        }
    }

    // Переопределение методов

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return cash == person.cash && Objects.equals(namePerson, person.namePerson) && Objects.deepEquals(productPackage, person.productPackage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namePerson, cash, Arrays.hashCode(productPackage));
    }

    @Override
    public String toString() {
        return "Покупатель{" +
                "Имя='" + namePerson + '\'' +
                ", денежные средства=" + cash +
                ", пакет с продуктами=" + Arrays.toString(productPackage) +
                '}';
    }
}
