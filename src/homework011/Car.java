package homework011;

public class Car {
    // Поля класса
    private String number;
    private String model;
    private String color;
    private int mileage;
    private int value;

    // Конструктор
    public Car(String number, String model, String color, int mileage, int value) {
        this.number = number;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.value = value;
    }

    // Геттеры и сеттеры

    public String getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getMileage() {
        return mileage;
    }

    public int getValue() {
        return value;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // Переопределение метода toString

    @Override
    public String toString() {
        return "Автомобиль{" +
                "Номер автомобиля='" + number + '\'' +
                ", Модель='" + model + '\'' +
                ", Цвет='" + color + '\'' +
                ", Пробег=" + mileage +
                ", Стоимость=" + value +
                '}';
    }
}