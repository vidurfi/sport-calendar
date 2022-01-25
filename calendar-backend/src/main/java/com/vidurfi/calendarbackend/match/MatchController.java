package com.vidurfi.calendarbackend.match;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;

@Controller
@RequestMapping(path = "/matches")
public class MatchController {

    @Autowired
    private MatchRepository matchRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewMatch (
            @RequestParam LocalDateTime date,
            @RequestParam String homeTeam,
            @RequestParam String awayTeam,
            @RequestParam String city,
            @RequestParam String sport,
            @RequestParam String stadium) {
    //TODO: Create add logic operation
    return "Match added";
    }

    @GetMapping(path = "/all")
    public @ResponseBody ArrayList<MatchJson> getAllMatches() {
        //TODO: cleanup all return - create a static class of MatchUtils for all helper methods
        Set<Match> matchSet = Sets.newHashSet(matchRepository.findAll());
        ArrayList<MatchJson> matchArray = new ArrayList<>();
        matchSet.parallelStream().forEach((match)->{
            matchArray.add(new MatchJson(match.getDateTime(), match.getHomeTeam().getName(),match.getAwayTeam().getName(),match.getSport().getName(),match.getStadium().getName(),match.getStadium().getCity().getName()));
        });

        return matchArray;
    }

    @PostMapping(path = "/filteredAll")
    public @ResponseBody Iterable<Match> getFilteredMatches(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String sport,
            @RequestParam(required = false) String stadium,
            @RequestParam(required = false) String team) {
        //TODO: Create Filter logic
        return matchRepository.findAll();
    }

}
