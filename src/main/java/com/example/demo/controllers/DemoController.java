package com.example.demo.controllers;

import com.example.demo.models.ElevationInfo;
import com.example.demo.models.TimeZoneInfo;
import com.example.demo.models.WeatherInfo;
import com.example.demo.services.GoogleApiService;
import com.example.demo.services.OpenWeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class DemoController {
    private final Logger logger = LoggerFactory.getLogger(DemoController.class);
    private final String format = "At the location %s, the temperature is %f, the timezone is %s, and the elevation is %f";
    @Autowired
    private OpenWeatherService openWeatherService;
    @Autowired
    private GoogleApiService googleApiService;

    @RequestMapping(path = "/demo")
    public String demo(@RequestParam(value = "zipcode") String zipcode) {
        if (!isZipcode(zipcode)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid zipcode");
        }
        try {
            WeatherInfo weatherInfo = openWeatherService.getWeatherInfo(zipcode);
            String location = weatherInfo.getName();
            double temperature = weatherInfo.getMain().getTemp();
            double lat = weatherInfo.getCoord().getLat();
            double lon = weatherInfo.getCoord().getLon();
            TimeZoneInfo timeZoneInfo = googleApiService.getTimeZone(lat, lon);
            String timezone = timeZoneInfo.getTimeZoneName();
            ElevationInfo elevationInfo = googleApiService.getElevation(lat, lon);
            double elevation = elevationInfo.getResults().get(0).getElevation();
            String result = String.format(format, location, temperature, timezone, elevation);
            logger.info("result: {}", result);
            return result;
        } catch (Exception e) {
            logger.error("error in /demo for zipcode:{}", zipcode, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    public static boolean isZipcode(String zipcode) {
        if (zipcode == null || zipcode.length() != 5) {
            return false;
        }
        for (int i = 0; i < zipcode.length(); i++) {
            if (!Character.isDigit(zipcode.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
