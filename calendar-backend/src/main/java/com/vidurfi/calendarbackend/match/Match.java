package com.vidurfi.calendarbackend.match;

import com.vidurfi.calendarbackend.sport.Sport;
import com.vidurfi.calendarbackend.stadium.Stadium;
import com.vidurfi.calendarbackend.team.Team;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Match")
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    private LocalDateTime dateTime;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "_home_team_id")
    private Team homeTeam;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "_away_team_id")
    private Team awayTeam;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "_sport_id")
    private Sport sport;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "_stadium_id" )
    private Stadium stadium;

    public void updateMatch(Match match){
        this.dateTime = match.getDateTime();
        this.homeTeam = match.getHomeTeam();
        this.awayTeam = match.getAwayTeam();
        this.sport = match.getSport();
        this.stadium = match.getStadium();
    }

    public Match() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }
}
