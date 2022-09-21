package kz.bitlab.javapro.javaproboot.controllers;

import kz.bitlab.javapro.javaproboot.Service.CarService;
import kz.bitlab.javapro.javaproboot.Service.impl.CarServimpl;
import kz.bitlab.javapro.javaproboot.beans.repository.CarRepository;
import kz.bitlab.javapro.javaproboot.beans.repository.CategoryRepository;
import kz.bitlab.javapro.javaproboot.beans.repository.CountryRepository;
import kz.bitlab.javapro.javaproboot.model.Car;
import kz.bitlab.javapro.javaproboot.model.Category;
import kz.bitlab.javapro.javaproboot.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping(value = "/")
    public String indexPage(Model model){
        List<Car> cars = carRepository.findAll();
        model.addAttribute("cars", cars);
        return "indexpage";
    }

    @GetMapping(value = "/addcar")
    public String addCar(Model model){
        List<Country> countries = countryRepository.findAll();
        model.addAttribute("countries", countries);
        return "addcar";
    }

    @PostMapping(value = "/addcar")
    public String addCar(@ModelAttribute("carObj") Car carObj,
                         @RequestParam(name = "country_id") Long countryId){


           Car newCar = carService.addCar(carObj, countryId);
        return (newCar!=null?"redirect:/details/"+newCar.getId():"redirect:/");
    }

    @GetMapping(value = "/details/{id}")
    public String details(@PathVariable(name = "id") Long id,
                          Model model){
        Car car = carRepository.findById(id).orElse(null);
        model.addAttribute("car", car);

        double carVolume = carRepository.getEngineVolume(id);
        model.addAttribute("volume", carVolume);

        List<Country> countries  = countryRepository.findAll();
        model.addAttribute("countries", countries);

        List<Category> categories = categoryRepository.findAll();

        if (car.getCategories()!=null){
            categories.removeAll(car.getCategories());
        }

        model.addAttribute("categories", categories);

        return "details";
    }

    @PostMapping(value = "/savecar")
    public String saveCar(@ModelAttribute("carObj") Car carObj,
                            @RequestParam(name = "country_id") Long countryId){

        Car newCar = carService.addCar(carObj, countryId);
        return (newCar!=null?"redirect:/details/"+newCar.getId():"redirect:/");
    }

    @PostMapping(value = "/deletecar")
    public String deleteCar(@RequestParam(name = "id") Long id){
        carRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping(value = "/assigncategory")
    public String assignCategory(@RequestParam(name = "id") Long id,
                                 @RequestParam(name = "car_id") Long carId){

        Car car = carRepository.findById(carId).orElse(null);
        List<Category> categories = car.getCategories();
        if(categories==null){
            categories = new ArrayList<>();
        }
        Category category = categoryRepository.findById(id).orElseThrow();
        categories.add(category);
        car.setCategories(categories);
        carRepository.save(car);
        return "redirect:/details/"+carId;
    }

    @PostMapping(value = "/unassigncategory")
    public String unassignCategory(@RequestParam(name = "id") Long id,
                                 @RequestParam(name = "car_id") Long carId){

        Car car = carRepository.findById(carId).orElse(null);
        List<Category> categories = car.getCategories();
        if(categories==null){
            categories = new ArrayList<>();
        }
        Category category = categoryRepository.findById(id).orElseThrow();
        categories.remove(category);
        car.setCategories(categories);
        carRepository.save(car);
        return "redirect:/details/"+carId;
    }
}
