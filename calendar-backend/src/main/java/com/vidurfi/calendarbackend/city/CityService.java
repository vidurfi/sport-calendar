package com.vidurfi.calendarbackend.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        return cityRepository.findById(id).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NO_CONTENT));}

    public City getCityByName(String name){
        return cityRepository.findByName(name);
    }

    public String deleteCity(int id){
        cityRepository.deleteById(id);
        return "City id#" + id + " successfully deleted!";
    }

    public City updateCity(City city){
        City oldCity = cityRepository.findById(city.getId()).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NO_CONTENT));
        oldCity.updateCity(city);
        return cityRepository.save(oldCity);
    }
}
