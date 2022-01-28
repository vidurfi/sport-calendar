package com.vidurfi.calendarbackend.sport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        return sportRepository.findById(id).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NO_CONTENT));
    }

    public Sport getSportByName(String name){
        return sportRepository.findByName(name);
    }

    public String deleteSport(int id){
        sportRepository.deleteById(id);
        return "Sport id#" + id + " successfully deleted!";
    }

    public Sport updateSport(Sport sport){
        Sport oldSport = sportRepository.findById(sport.getId()).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NO_CONTENT));
        oldSport.updateSport(sport);
        return sportRepository.save(oldSport);
    }
}
