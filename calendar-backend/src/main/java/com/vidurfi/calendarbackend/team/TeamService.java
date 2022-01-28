package com.vidurfi.calendarbackend.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team addTeam(Team team){
        return teamRepository.save(team);
    }

    public Iterable<Team> addTeams(Iterable<Team> teams){
        return teamRepository.saveAll(teams);
    }

    public Iterable<Team> getTeams(){
        return teamRepository.findAll();
    }

    public Team getTeamById(Integer id){
        return teamRepository.findById(id).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NO_CONTENT));
    }

    public Team getTeamByName(String name){
        return teamRepository.findByName(name);
    }

    public String deleteTeam(int id){
        teamRepository.deleteById(id);
        return "Team id#" + id + " successfully deleted!";
    }

    public Team updateTeam(Team team){
        Team oldTeam = teamRepository.findById(team.getId()).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NO_CONTENT));
        oldTeam.updateTeam(team);
        return teamRepository.save(oldTeam);
    }
}
