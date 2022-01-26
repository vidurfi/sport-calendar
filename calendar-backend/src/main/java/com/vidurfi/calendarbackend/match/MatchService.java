package com.vidurfi.calendarbackend.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public Match addMatch(Match match){
        return matchRepository.save(match);
    }

    public Iterable<Match> addMatches(Iterable<Match> matches){
        return matchRepository.saveAll(matches);
    }

    public Iterable<Match> getMatches(){
        return matchRepository.findAll();
    }

    public Match getMatchById(Integer id){
        return matchRepository.findById(id).orElse(null);
    }

    public String deleteMatch(int id){
        matchRepository.deleteById(id);
        return "Match id#" + id + " successfully deleted!";
    }

    public Match updateMatch(Match match){
        Match oldMatch = matchRepository.findById(match.getId()).orElse(null);
        oldMatch.updateMatch(match);
        return matchRepository.save(oldMatch);
    }
}
