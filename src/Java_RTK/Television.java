package Java_RTK;

public class Television {
    // Поля класса
    private String brand;
    private int screenSize;
    private boolean isOn;
    private int volume;

    // Конструктор
    public Television(String brand, int screenSize, boolean isOn, int volume) {
        this.brand = brand;
        this.screenSize = screenSize;
        this.isOn = isOn;
        this.volume = volume;
    }

    // Геттеры и сеттеры
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        this.isOn = on;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume < 0) {
            this.volume = 0;
        } else if (volume > 100) {
            this.volume = 100;
        } else {
            this.volume = volume;
        }
    }

    // Методы для управления
    public void turnOn() {
        this.isOn = true;
        System.out.println("Телевизор включен");
    }

    public void turnOff() {
        this.isOn = false;
        System.out.println("Телевизор выключен");
    }

    public void increaseVolume() {
        if (volume < 100) {
            volume++;
            System.out.println("Громкость увеличена до " + volume);
        } else {
            System.out.println("громкость уже на максимуме");
        }
    }

    public void decreaseVolume() {
        if (volume > 0) {
            volume--;
            System.out.println("Громкость уменьшена до " + volume);
        } else {
            System.out.println("Громкость уже на минимуме");
        }
    }

    // Переопределение метода toSting для удобства вывода
    @Override
    public String toString() {
        return "Телевизор {" +
                "бренд='" + brand + '\'' +
                ", размер экрана=" + screenSize + " дюймов" +
                ", включен=" + isOn +
                ", громкость=" + volume +
                '}';
    }
}
