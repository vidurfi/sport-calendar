package com.vidurfi.calendarbackend.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public City addCity(City city){
        return cityRepository.save(city);
    }

    public Iterable<City> addCities(Iterable<City> cities){
        return cityRepository.saveAll(cities);
    }

    public Iterable<City> getCities(){
        return cityRepository.findAll();
    }

    public City getCityById(Integer id){
        return cityRepository.findById(id).orElse(null);
    }

    public City getCityByName(String name){
        return cityRepository.findByName(name);
    }

    public String deleteCity(int id){
        cityRepository.deleteById(id);
        return "City id#" + id + " successfully deleted!";
    }

    public City updateCity(City city){
        City oldCity = cityRepository.findById(city.getId()).orElse(null);
        oldCity.updateCity(city);
        return cityRepository.save(oldCity);
    }
}
