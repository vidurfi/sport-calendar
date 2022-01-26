package com.vidurfi.calendarbackend.team;

import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Integer> {
    Team findByName(String name);
}
