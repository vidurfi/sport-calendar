package com.vidurfi.calendarbackend.stadium;

import com.vidurfi.calendarbackend.city.City;

import javax.persistence.*;

@Entity(name = "Stadium")
@Table(name = "stadiums")
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "stadium_name")
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "_city_id")
    private City city;

    public void updateStadium(Stadium stadium){
        this.name = stadium.getName();
        this.city = stadium.getCity();
    }

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
}
