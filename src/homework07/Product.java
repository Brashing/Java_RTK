package homework07;

import java.util.Objects;

public class Product {
    // Поля класса
    private String title;
    protected int value; // доступ в классе наследнике

    // Конструктор
    public Product(String title, int value) {
        // Проверка названия продукта
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }
        if (title.matches("\\d+")) {
            throw new IllegalArgumentException("Название не может содержать только цифры");
        }
        if (title.length() < 3) {
            throw new IllegalArgumentException("Название должно содержать не менее 3 символов");
        }
        this.title = title;

        // Проверка стоимости
        if (value <= 0) {
            throw new IllegalArgumentException("Стоимость должна быть положительной");
        }
        this.value = value;
    }

    // Геттеры и сеттеры
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }
        if (title.matches("\\d+")) {
            throw new IllegalArgumentException("Название не может содержать только цифры");
        }
        if (title.length() < 3) {
            throw new IllegalArgumentException("Название должно содержать не менее 3 символов");
        }
        this.title = title;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Стоимость должна быть положительной");
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return value == product.value && Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, value);
    }

    // Метод toString() для вывода объекта
    @Override
    public String toString() {
        return "Продукт{" +
                "название='" + title + '\'' +
                ", стоимость=" + value +
                '}';
    }

}
