package com.vidurfi.calendarbackend.sport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/sports")
public class SportController {

    @Autowired
    private SportService sportService;

    @PostMapping(path = "/addSport")
    public Sport addSport (@RequestBody Sport sport) {
        return sportService.addSport(sport);
    }

    @PostMapping(path = "/addSports")
    public Iterable<Sport> addSports (@RequestBody Iterable<Sport> sports) {
        return sportService.addSports(sports);
    }

    @GetMapping(path = "/all")
    public Iterable<Sport> getAllSports() {
        return sportService.getSports();
    }

    @GetMapping(path = "/get/{id}")
    public Sport getSportById(@PathVariable int id){
        return sportService.getSportById(id);
    }

    @GetMapping(path = "/getByName/{name}")
    public Sport getSportByName(@PathVariable String name){
        return sportService.getSportByName(name);
    }

    @PutMapping(path = "/update")
    public Sport updateSport(@RequestBody Sport sport){
        return sportService.updateSport(sport);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteSport(@PathVariable int id){
        return sportService.deleteSport(id);
    }
}
