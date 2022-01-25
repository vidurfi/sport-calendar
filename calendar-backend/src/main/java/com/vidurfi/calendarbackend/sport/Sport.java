package com.vidurfi.calendarbackend.sport;

import javax.persistence.*;

@Entity
@Table(name = "sports")
public class Sport {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "sport_name")
    private String name;

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
}
