package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Wither;

import java.util.List;

@Value
@Builder(toBuilder = true)
@Wither
@AllArgsConstructor
public class WeatherInfo {
    @Value
    public static class Main {
        private double temp;
        private int pressure;
        private int humidity;
        private double temp_min;
        private double temp_max;
    }

    private long id;
    private String name;
    private Coord coord;
    private WeatherInfo.Main main;
    private List<Weather> weather;
}