package com.example.restclient.services;

import com.example.restclient.entities.Site;
import com.example.restclient.json.GeocoderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GeocoderService {

//    private static final String API_KEY = "AIzaSyBdbDxIIOTXzfNgIW-ySXQG4JSADdT0U9A"; // Personal key not working atm??
    private static final String API_KEY = "AIzaSyDw_d6dfxDEI7MAvqfGXEIsEMwjC1PWRno";
    private static final String BASE_URL = "https://maps.googleapis.com/maps/api/geocode/json?";
    private final RestTemplate restTemplate;

    @Autowired
    public GeocoderService(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    private String encode(String s) {
        return URLEncoder.encode(s, StandardCharsets.UTF_8);
    }

    /**
     * Returns the location from the address
     * @param address
     * @return
     */
    // https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,
    //+Mountain+View,+CA&key=YOUR_API_KEY
    public Site getLocation(String... address) { // JAVA VARARGS -- https://stackoverflow.com/questions/2367398/what-is-the-ellipsis-for-in-this-method-signature

        String encodedAddress = Stream.of(address)
                .map(this::encode)
                .collect(Collectors.joining(","));
        String url = MessageFormat.format("{0}address={1}&key={2}&sensor=true", BASE_URL, encodedAddress, API_KEY);
//        System.out.println(url);
        GeocoderResponse response = restTemplate.getForObject(url, GeocoderResponse.class);
//        System.out.println(response.toString());

        return new Site(response.getFormatedAddress(), response.getLat(), response.getLng());
    }



}
