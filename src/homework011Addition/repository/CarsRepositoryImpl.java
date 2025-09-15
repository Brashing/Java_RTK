package homework011Addition.repository;

import homework011Addition.model.Car;

import java.io.*;
import java.util.*;

public class CarsRepositoryImpl implements CarsRepository {
    private final String inputFilePath;

    public CarsRepositoryImpl(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = br.readLine()) != null && !line.trim().equalsIgnoreCase("END")) {
                String[] parts = line.trim().split("\\|");
                if (parts.length == 5) {
                    String number = parts[0].trim();
                    String model = parts[1].trim();
                    String color = parts[2].trim();
                    int mileage = Integer.parseInt(parts[3].trim());
                    int value = Integer.parseInt(parts[4].trim());
                    cars.add(new Car(number, model, color, mileage, value));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cars;
    }
}
