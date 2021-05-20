package com.example.controllers;

import com.example.entities.Greetings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRestControllerIntegrationTest {


    // Get the entity allows us to check more metadata, eg status code
    @Test
    public void greetWithoutName(@Autowired TestRestTemplate template) {
        ResponseEntity<Greetings> entity = template.getForEntity("/rest", Greetings.class);
        // check meta data
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
        // check body
        Greetings response = entity.getBody();
        if (response != null) {
            assertEquals("Hello World!", response.getMessage());
        }
    }

    // Check only body with the get body
    @Test
    public void greetWithName(@Autowired TestRestTemplate template) {
        Greetings response = template.getForObject("/rest?name=nice", Greetings.class);
        assertEquals("Hello nice!", response.getMessage());
    }
}
