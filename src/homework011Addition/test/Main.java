package homework011Addition.test;

import homework011Addition.model.Car;
import homework011Addition.repository.CarsRepository;
import homework011Addition.repository.CarsRepositoryImpl;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Пути к файлам
        String inputFile = "C:\\Users\\roman\\IdeaProjects\\Java_RTK\\src\\homework011Addition\\data\\cars.txt";
        String outputFile = "C:\\Users\\roman\\IdeaProjects\\Java_RTK\\src\\homework011Addition\\data\\result.txt";

        CarsRepository repo = new CarsRepositoryImpl(inputFile);
        List<Car> cars = repo.getAllCars();

        try (
                PrintWriter pw = new PrintWriter(new FileWriter(outputFile))
        ) {

            // 0) Вывод всей таблицы автомобилей
            pw.println("Автомобили в базе:");
            pw.printf("%-10s | %-10s | %-8s | %-8s | %-10s%n", "Номер", "Модель", "Цвет", "Пробег", "Стоимость");
            pw.println("--------------------------------------------------------------");
            for (Car c : cars) {
                pw.printf("%-10s | %-10s | %-8s | %-8d | %-10d%n",
                        c.getNumber(), c.getModel(), c.getColor(), c.getMileage(), c.getValue());
            }
            pw.println();

            // Переменные
            String colorToFind = "Black";               // цвет авто
            int mileageToFind = 0;                      // нулевой пробег
            int n = 700;                                // диапазон (тыс.км)
            int m = 800;                                // диапазон (тыс.км)
            String[] modelsToAvg = {"Toyota", "Volvo"}; // модели для определения средней стоимости

            // 1) Номера всех автомобилей с заданным цветом или нулевым пробегом
            List<String> result1 = cars.stream()
                    .filter(c -> c.getColor().equalsIgnoreCase(colorToFind) || c.getMileage() == mileageToFind)
                    .map(Car::getNumber)
                    .toList();

            pw.print("1) Номера автомобилей по цвету " + colorToFind + " или пробегу " + mileageToFind + ": ");
            result1.forEach(s -> pw.print(s + " "));
            pw.println();

            // 2) Количество уникальных моделей в ценовом диапазоне от n до m тысяч
            long countModels = cars.stream()
                    .map(Car::getModel)
                    .distinct()
                    .filter(model ->
                            cars.stream()
                                    .anyMatch(c -> c.getModel()
                                            .equalsIgnoreCase(model) && c.getValue() >= n * 1000 && c.getValue() <= m * 1000))
                    .count();
            pw.print("2) Количество уникальных моделей автомобилей в ценовом диапазоне " + n + " - " + m + " тыс.руб.: " + countModels);
            pw.println();

            // 3) Цвет автомобиля с минимальной стоимостью
            Optional<Car> minPriceCarOpt = cars.stream()
                    .min(Comparator.comparingInt(Car::getValue));
            pw.print("3) Цвет автомобиля с минимальной стоимостью: ");
            minPriceCarOpt.ifPresent(car -> pw.print(car.getColor()));
            pw.println();

            // 4) Средняя стоимость для заданных моделей
            for (String modelToFind : modelsToAvg) {
                OptionalDouble avgPrice = cars.stream()
                        .filter(c -> c.getModel().equalsIgnoreCase(modelToFind))
                        .mapToInt(Car::getValue)
                        .average();

                pw.print("4) Средняя стоимость модели " + modelToFind + ": ");
                if (avgPrice.isPresent()) {
                    pw.println(avgPrice.getAsDouble());
                } else {
                    pw.println("0.0");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
