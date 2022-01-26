package com.vidurfi.calendarbackend.team;

import com.vidurfi.calendarbackend.city.City;
import com.vidurfi.calendarbackend.sport.Sport;

import javax.persistence.*;

@Entity(name = "Team")
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "team_name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "_city_id")
    private City city;
    @ManyToOne
    @JoinColumn(name = "_sport_id")
    private Sport sport;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
