package com.vidurfi.calendarbackend.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/teams")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;
}
