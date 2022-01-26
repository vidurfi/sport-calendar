package com.vidurfi.calendarbackend.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping(path = "/addTeam")
    public Team addTeam (@RequestBody Team team) {
        return teamService.addTeam(team);
    }

    @PostMapping(path = "/addTeams")
    public Iterable<Team> addTeams (@RequestBody Iterable<Team> teams) {
        return teamService.addTeams(teams);
    }

    @GetMapping(path = "/all")
    public Iterable<Team> getAllTeams() {
        return teamService.getTeams();
    }

    @GetMapping(path = "/get/{id}")
    public Team getTeamById(@PathVariable int id){
        return teamService.getTeamById(id);
    }

    @GetMapping(path = "/getByName/{name}")
    public Team getTeamByName(@PathVariable String name){
        return teamService.getTeamByName(name);
    }

    @PutMapping(path = "/update")
    public Team updateTeam(@RequestBody Team team){
        return teamService.updateTeam(team);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteTeam(@PathVariable int id){
        return teamService.deleteTeam(id);
    }
}
