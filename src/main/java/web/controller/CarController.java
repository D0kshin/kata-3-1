package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    @GetMapping(value = "/cars")
    public String printCars( @RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car("BMW", "white", 2001));
        cars.add(new Car("Mercedes", "black", 2002));
        cars.add(new Car("Audi", "black", 2003));
        cars.add(new Car("Ford", "green", 2004));
        cars.add(new Car("BMW", "green", 2005));

        CarService carService = new CarServiceImpl();
        List<Car> specialAmountOfCars = carService.getSpecialAmountOfCars(cars, count);
        model.addAttribute("cars", specialAmountOfCars);

        return "cars";
    }
}
