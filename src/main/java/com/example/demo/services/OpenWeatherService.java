package com.example.demo.services;

import com.example.demo.models.WeatherInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherService {
    private static Logger logger = LoggerFactory.getLogger(OpenWeatherService.class);
    private RestTemplate restTemplate = new RestTemplate();
    private final String urlFormat = "http://api.openweathermap.org/data/2.5/weather?zip=%s&APPID=%s";
    private final String appId = System.getenv("OPENWEATHER_APPID");
    private final Gson gson = new GsonBuilder().create();

    public WeatherInfo getWeatherInfo(String zipcode) {
        String url = String.format(urlFormat, zipcode, appId);
        ResponseEntity response = restTemplate.getForEntity(url, String.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            logger.error("error fetching weather info");
            throw new OpenWeatherServiceException();
        }
        return gson.fromJson(response.getBody().toString(), WeatherInfo.class);
    }
}
