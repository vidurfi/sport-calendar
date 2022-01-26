package com.vidurfi.calendarbackend.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping(path = "/addCity")
    public City addCity (@RequestBody City city) {
        return cityService.addCity(city);
    }

    @PostMapping(path = "/addCities")
    public Iterable<City> addCities (@RequestBody Iterable<City> cities) {
        return cityService.addCities(cities);
    }

    @GetMapping(path = "/all")
    public Iterable<City> getAllCities() {
        return cityService.getCities();
    }

    @GetMapping(path = "/get/{id}")
    public City getCityById(@PathVariable int id){
        return cityService.getCityById(id);
    }

    @GetMapping(path = "/getByName/{name}")
    public City getCityByName(@PathVariable String name){
        return cityService.getCityByName(name);
    }

    @PutMapping(path = "/update")
    public City updateCity(@RequestBody City city){
        return cityService.updateCity(city);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteCity(@PathVariable int id){
        return cityService.deleteCity(id);
    }
}
