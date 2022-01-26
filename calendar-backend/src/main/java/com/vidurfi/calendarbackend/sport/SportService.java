package com.vidurfi.calendarbackend.sport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportService {

    @Autowired
    private SportRepository sportRepository;

    public Sport addSport(Sport sport){
        return sportRepository.save(sport);
    }

    public Iterable<Sport> addSports(Iterable<Sport> sports){
        return sportRepository.saveAll(sports);
    }

    public Iterable<Sport> getSports(){
        return sportRepository.findAll();
    }

    public Sport getSportById(Integer id){
        return sportRepository.findById(id).orElse(null);
    }

    public String deleteSport(int id){
        sportRepository.deleteById(id);
        return "Sport id#" + id + " successfully deleted!";
    }

    public Sport updateSport(Sport sport){
        Sport oldSport = sportRepository.findById(sport.getId()).orElse(null);
        oldSport.updateSport(sport);
        return sportRepository.save(oldSport);
    }
}
