package com.vidurfi.calendarbackend.match;

import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.time.LocalDateTime;

public class MatchJson {
    private LocalDateTime date;
    private String homeTeam;
    private String awayTeam;
    private String sport;
    private String stadium;
    private String city;

    public MatchJson(LocalDateTime date, String homeTeam, String awayTeam, String sport, String stadium, String city) {
        this.date = date;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.sport = sport;
        this.stadium = stadium;
        this.city = city;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
