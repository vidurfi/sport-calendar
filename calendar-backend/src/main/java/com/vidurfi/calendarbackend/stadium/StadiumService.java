package com.vidurfi.calendarbackend.stadium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return stadiumRepository.findById(id).orElse(null);
    }

    public String deleteStadium(int id){
        stadiumRepository.deleteById(id);
        return "Stadium id#" + id + " successfully deleted!";
    }

    public Stadium updateStadium(Stadium stadium){
        Stadium oldStadium = stadiumRepository.findById(stadium.getId()).orElse(null);
        oldStadium.updateStadium(stadium);
        return stadiumRepository.save(oldStadium);
    }
}
