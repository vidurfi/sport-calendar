package com.vidurfi.calendarbackend.stadium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/stadiums")
public class StadiumController {

    @Autowired
    private StadiumService stadiumService;

    @PostMapping(path = "/addStadium")
    public Stadium addStadium (@RequestBody Stadium stadium) {
        return stadiumService.addStadium(stadium);
    }

    @PostMapping(path = "/addStadiums")
    public Iterable<Stadium> addStadiums (@RequestBody Iterable<Stadium> stadiums) {
        return stadiumService.addStadiums(stadiums);
    }

    @GetMapping(path = "/all")
    public Iterable<Stadium> getAllStadiums() {
        return stadiumService.getStadiums();
    }

    @GetMapping(path = "/get/{id}")
    public Stadium getStadiumById(@PathVariable int id){
        return stadiumService.getStadiumById(id);
    }

    @GetMapping(path = "/getByName/{name}")
    public Stadium getStadiumByName(@PathVariable String name){
        return stadiumService.getStadiumByName(name);
    }

    @PutMapping(path = "/update")
    public Stadium updateStadium(@RequestBody Stadium stadium){
        return stadiumService.updateStadium(stadium);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteStadium(@PathVariable int id){
        return stadiumService.deleteStadium(id);
    }
}
