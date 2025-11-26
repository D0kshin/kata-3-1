package web.service;

import web.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getSpecialAmountOfCars(List<Car> cars, int amount);
}
