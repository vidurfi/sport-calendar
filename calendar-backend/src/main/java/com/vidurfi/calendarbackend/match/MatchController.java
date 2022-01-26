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
    public @ResponseBody Iterable<Match> addMatches (@RequestBody Iterable<Match> matches) {
        return matchService.addMatches(matches);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Match> getAllMatches() {
        return matchService.getMatches();
    }

    @GetMapping(path = "/get/{id}")
    public @ResponseBody Match getMatchById(@PathVariable int id){
        return matchService.getMatchById(id);
    }

    @PutMapping(path = "/update")
    public @ResponseBody Match updateMatch(@RequestBody Match match){
        return matchService.updateMatch(match);
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody String deleteMatch(@PathVariable int id){
        return matchService.deleteMatch(id);
    }
}
