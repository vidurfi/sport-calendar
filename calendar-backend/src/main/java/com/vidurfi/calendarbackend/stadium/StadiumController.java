package com.vidurfi.calendarbackend.stadium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/stadiums")
public class StadiumController {

    @Autowired
    private StadiumService stadiumService;
}
