package com.vidurfi.calendarbackend.stadium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class StadiumService {

    @Autowired
    private StadiumRepository stadiumRepository;

    public Stadium addStadium(Stadium stadium){
        return stadiumRepository.save(stadium);
    }

    public Iterable<Stadium> addStadiums(Iterable<Stadium> stadiums){
        return stadiumRepository.saveAll(stadiums);
    }

    public Iterable<Stadium> getStadiums(){
        return stadiumRepository.findAll();
    }

    public Stadium getStadiumById(Integer id){
        return stadiumRepository.findById(id).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NO_CONTENT));
    }

    public Stadium getStadiumByName(String name){
        return stadiumRepository.findByName(name);
    }

    public String deleteStadium(int id){
        stadiumRepository.deleteById(id);
        return "Stadium id#" + id + " successfully deleted!";
    }

    public Stadium updateStadium(Stadium stadium){
        Stadium oldStadium = stadiumRepository.findById(stadium.getId()).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NO_CONTENT));
        oldStadium.updateStadium(stadium);
        return stadiumRepository.save(oldStadium);
    }
}
