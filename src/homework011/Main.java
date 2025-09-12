package homework011;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>(List.of(
                new Car("a123me", "Mersedes", "White", 0, 8300000),
                new Car("b873of", "Volga", "Black", 0, 673000),
                new Car("w487mn", "Lexus", "Grey", 76000, 900000),
                new Car("p987hj", "Volga", "Red", 610, 704340),
                new Car("c987ss", "Toyota", "White", 254000, 761000),
                new Car("o983op", "Toyota", "Black", 698000, 740000),
                new Car("p146op", "BMW", "White", 271000, 850000),
                new Car("u893ii", "Toyota", "Purple", 210900, 440000),
                new Car("l097df", "Toyota", "Black", 108000, 780000),
                new Car("y876wd", "Toyota", "Black", 160000, 1000000)
        ));

        // Переменные
        String colorToFind = "Black";               // цвет авто
        int mileageToFind = 0;                      // нулевой пробег
        int n = 700;                                // диапазон (тыс.км)
        int m = 800;                                // диапазон (тыс.км)
        String[] modelsToAvg = {"Toyota", "Volvo"}; // модели для определения средней стоимости

        // 0) Вывод всей таблицы автомобилей
        System.out.println("Автомобили в базе:");
        System.out.printf("%-10s | %-10s | %-8s | %-8s | %-10s%n", "Номер", "Модель", "Цвет", "Пробег", "Стоимость");
        System.out.println("--------------------------------------------------------------");
        for (Car c : cars) {
            System.out.printf("%-10s | %-10s | %-8s | %-8d | %-10d%n",
                    c.getNumber(), c.getModel(), c.getColor(), c.getMileage(), c.getValue());
        }
        System.out.println();

        // 1) Номера всех автомобилей с заданным цветом или нулевым пробегом
        List<String> result1 = cars.stream()
                .filter(c -> c.getColor().equalsIgnoreCase(colorToFind) || c.getMileage() == mileageToFind)
                .map(Car::getNumber)
                .collect(Collectors.toList());

        System.out.print("1) Номера автомобилей по цвету " + colorToFind + " или пробегу " + mileageToFind + ": ");
        result1.forEach(s -> System.out.print(s + " "));
        System.out.println();

        // 2) Количество уникальных моделей в ценовом диапазоне от n до m тысяч
        long countModels = cars.stream()
                .map(Car::getModel)
                .distinct()
                .filter(model ->
                        cars.stream()
                                .anyMatch(c -> c.getModel()
                                        .equalsIgnoreCase(model) && c.getValue() >= n * 1000 && c.getValue() <= m*1000))
                .count();
        System.out.print("2) Количество уникальных моделей автомобилей в ценовом диапазоне " + n + " - " + m + " тыс.: " + countModels);
        System.out.println();

        // 3) Цвет автомобиля с минимальной стоимостью
        Optional<Car> minPriceCarOpt = cars.stream()
                .min(Comparator.comparingInt(Car::getValue));
        System.out.print("3) Цвет автомобиля с минимальной стоимостью: ");
        minPriceCarOpt.ifPresent(car -> System.out.print(car.getColor()));
        System.out.println();

        // 4) Средняя стоимость для заданных моделей
        for (String modelToFind : modelsToAvg) {
            OptionalDouble avgPrice = cars.stream()
                    .filter(c -> c.getModel().equalsIgnoreCase(modelToFind))
                    .mapToInt(Car::getValue)
                    .average();

            System.out.print("4) Средняя стоимость модели " + modelToFind + ": ");
            if (avgPrice.isPresent()) {
                System.out.println(avgPrice.getAsDouble());
            } else {
                System.out.println("0,0");
            }
        }
    }
}