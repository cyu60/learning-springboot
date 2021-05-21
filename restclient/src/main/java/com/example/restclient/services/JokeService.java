package com.example.restclient.services;

import com.example.restclient.json.JokeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeService {
    private static final String BASE_URL = "http://api.icndb.com/jokes/random?exclude=[nerdy]";
    private final RestTemplate restTemplate;

    @Autowired
    public JokeService(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public String getJoke(String firstName, String lastName) {
        String url = String.format("%s&firstName=%s&lastName=%s", BASE_URL, firstName, lastName);
        JokeResponse jokeResponse = restTemplate.getForObject(url, JokeResponse.class);
        String output = "";
        if (jokeResponse != null) {
            output = jokeResponse.getValue().getJoke();
        }
        return output;
    }
}
