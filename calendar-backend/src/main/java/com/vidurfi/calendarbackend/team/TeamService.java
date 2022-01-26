package com.vidurfi.calendarbackend.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return teamRepository.findById(id).orElse(null);
    }

    public Team getTeamByName(String name){
        return teamRepository.findByName(name);
    }

    public String deleteTeam(int id){
        teamRepository.deleteById(id);
        return "Team id#" + id + " successfully deleted!";
    }

    public Team updateTeam(Team team){
        Team oldTeam = teamRepository.findById(team.getId()).orElse(null);
        oldTeam.updateTeam(team);
        return teamRepository.save(oldTeam);
    }
}
