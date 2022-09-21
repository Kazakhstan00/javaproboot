package kz.bitlab.javapro.javaproboot.Service;

import kz.bitlab.javapro.javaproboot.model.Car;

public interface CarService {

    Car addCar(Car car, Long countryId);
    Car addCar(Car car);
    Car updateCar(Car car, Long countryId);
    Car saveCar(Car car);

}
