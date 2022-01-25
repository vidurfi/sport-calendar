package com.vidurfi.calendarbackend.team;

import com.vidurfi.calendarbackend.city.City;
import com.vidurfi.calendarbackend.sport.Sport;
import com.vidurfi.calendarbackend.stadium.Stadium;

import javax.persistence.*;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "team_name")
    private String name;
    @OneToOne
    @JoinColumn(name = "_city_id")
    private City city;
    @OneToOne
    @JoinColumn(name = "_sport_id")
    private Sport sport;
    @OneToOne
    @JoinColumn(name = "_stadium_id")
    private Stadium stadium;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
