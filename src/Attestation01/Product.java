package Attestation01;

import java.util.Objects;

public class Product {
    // Поля класса
    private String title;
    private int value;

    // Конструктор
    public Product(String title, int value) {
        // Проверка названия продукта
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }
        this.title = title;

        // Проверка стоимости
        if (value < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
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
        this.title = title;
    }

    public float getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
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
