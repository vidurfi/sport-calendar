package com.vidurfi.calendarbackend.sport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sports")
public class SportController {

    @Autowired
    private SportService sportService;
}
