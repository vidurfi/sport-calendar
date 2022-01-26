package com.vidurfi.calendarbackend.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cities")
public class CityController {

    @Autowired
    private CityService cityService;
}
