package com.example.restclient.services;

import com.example.restclient.entities.Site;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GeocoderServiceTest {
    private final Logger logger = LoggerFactory.getLogger(GeocoderService.class);

    // 1600+Amphitheatre+Parkway,+Mountain+View,+CA

    @Autowired
    private GeocoderService service;

    @Test
    public void getLocation() throws Exception{
        // site is basically the fetched data
        Site site = service.getLocation("1600 Amphitheatre Parkway", "Mountain View", "CA");
        logger.info(site.toString());

//        assertTrue(joke.contains(FIRST_NAME) || joke.contains(LAST_NAME));
    }
}