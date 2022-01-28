package com.vidurfi.calendarbackend.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Iterator;

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


    public Iterable<Match> getMatches(String teamName, String cityName, String sportName){
        Iterable<Match> matches = matchRepository.findAll();
        if ((teamName == null) && (cityName == null) && (sportName == null)) return matches;
        Iterator<Match> i = matches.iterator();
        while (i.hasNext()){
            Match match = i.next();
            if (!match.isToBeKept(teamName,cityName,sportName)) i.remove();
        }
        return matches;
    }

    public Match getMatchById(Integer id){
        return matchRepository.findById(id).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public String deleteMatch(int id){
        matchRepository.deleteById(id);
        return "Match id#" + id + " successfully deleted!";
    }

    public Match updateMatch(Match match){
        Match oldMatch = matchRepository.findById(match.getId()).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND));
        oldMatch.updateMatch(match);
        return matchRepository.save(oldMatch);
    }
}
