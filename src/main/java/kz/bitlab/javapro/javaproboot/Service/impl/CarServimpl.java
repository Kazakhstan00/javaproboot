package kz.bitlab.javapro.javaproboot.Service.impl;

import kz.bitlab.javapro.javaproboot.Service.CarService;
import kz.bitlab.javapro.javaproboot.beans.repository.CarRepository;
import kz.bitlab.javapro.javaproboot.beans.repository.CountryRepository;
import kz.bitlab.javapro.javaproboot.model.Car;
import kz.bitlab.javapro.javaproboot.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServimpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Car addCar(Car car, Long countryId) {
        Country country = countryRepository.findById(countryId).orElse(null);
        if (country!=null){
            car.setCountry(country);
            return addCar(car);
        }
        return null;
    }

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(Car car, Long countryId) {
        Country country = countryRepository.findById(countryId).orElse(null);
        if (country!=null){
            Car oldCar = carRepository.findById(car.getId()).orElse(null);
            if(oldCar!=null){
                oldCar.setName(car.getName());
                oldCar.setCountry(car.getCountry());
                oldCar.setEngineVolume(car.getEngineVolume());
                oldCar.setPrice(car.getPrice());
                oldCar.setModel(car.getModel());
                return carRepository.save(oldCar);
            }
        }
        return null;
    }

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }


}
