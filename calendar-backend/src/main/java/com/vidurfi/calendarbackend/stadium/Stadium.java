package com.vidurfi.calendarbackend.stadium;

import com.vidurfi.calendarbackend.city.City;

import javax.persistence.*;

@Entity
@Table(name = "stadiums")
public class Stadium {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "stadium_name")
    private String name;
    @OneToOne
    @JoinColumn(name = "_city_id")
    private City city;

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
