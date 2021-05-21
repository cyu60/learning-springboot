package com.example.restclient.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JokeServiceTest {
    private final Logger logger = LoggerFactory.getLogger(JokeService.class);
    private static final String FIRST_NAME = "Chinat";
    private static final String LAST_NAME = "Yu";

    @Autowired
    private JokeService service;

    @Test
    public void getJoke(){
        String joke = service.getJoke(FIRST_NAME, LAST_NAME);
        logger.info(joke);
        assertTrue(joke.contains(FIRST_NAME) || joke.contains(LAST_NAME));
    }

}