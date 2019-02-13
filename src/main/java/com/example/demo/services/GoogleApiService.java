package com.example.demo.services;

import com.example.demo.models.ElevationInfo;
import com.example.demo.models.TimeZoneInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleApiService {
    private static Logger logger = LoggerFactory.getLogger(GoogleApiService.class);
    private RestTemplate restTemplate = new RestTemplate();
    private final Gson gson = new GsonBuilder().create();
    private final String timezone_url =
            "https://maps.googleapis.com/maps/api/timezone/json?location=%f,%f&timestamp=%d&key=%s";
    private final String elevation_url =
            "https://maps.googleapis.com/maps/api/elevation/json?locations=%f,%f&key=%s";
    private String google_api_key = System.getenv("GOOGLE_API_KEY");

    public TimeZoneInfo getTimeZone(double lat, double lon) {
        try {
            long timestamp = System.currentTimeMillis() / 1000;
            String url = String.format(
                    timezone_url,
                    lat,
                    lon,
                    timestamp,
                    google_api_key
            );
            ResponseEntity response = restTemplate.getForEntity(url, String.class);
            if (response.getStatusCode() != HttpStatus.OK) {
                logger.error("error fetching weather info");
                throw new OpenWeatherServiceException();
            }
            return gson.fromJson(response.getBody().toString(), TimeZoneInfo.class);
        } catch (Exception e) {
            String msg = String.format("error getting timezone info for %f,%f", lat, lon);
            logger.error(msg, e);
            throw new GoogleApiServiceException(msg, e);
        }
    }

    public ElevationInfo getElevation(double lat, double lon) {
        try {
            String url = String.format(
                    elevation_url,
                    lat,
                    lon,
                    google_api_key
            );
            ResponseEntity response = restTemplate.getForEntity(url, String.class);
            if (response.getStatusCode() != HttpStatus.OK) {
                logger.error("error fetching elevetion info");
                throw new GoogleApiServiceException();
            }
            return gson.fromJson(response.getBody().toString(), ElevationInfo.class);
        } catch (Exception e) {
            String msg = String.format("error getting elevation info for %f,%f", lat, lon);
            logger.error(msg, e);
            throw new GoogleApiServiceException(msg, e);
        }
    }
}