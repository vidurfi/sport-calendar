package com.vidurfi.calendarbackend.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping(path = "/addMatch")
    public Match addMatch (@RequestBody Match match) {
        return matchService.addMatch(match);
    }

    @PostMapping(path = "/addMatches")
    public Iterable<Match> addMatches (@RequestBody Iterable<Match> matches) {
        return matchService.addMatches(matches);
    }

    @GetMapping(path = "/all")
    public Iterable<Match> getAllMatches(@RequestParam(value = "team", required = false) String teamName, @RequestParam(value = "city",required = false) String cityName, @RequestParam(value = "sport",required = false) String sportName) {
        return matchService.getMatches(teamName,cityName,sportName);
    }

    @GetMapping(path = "/get/{id}")
    public Match getMatchById(@PathVariable int id){
        return matchService.getMatchById(id);
    }

    @PutMapping(path = "/update")
    public Match updateMatch(@RequestBody Match match){
        return matchService.updateMatch(match);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteMatch(@PathVariable int id){
        return matchService.deleteMatch(id);
    }
}
