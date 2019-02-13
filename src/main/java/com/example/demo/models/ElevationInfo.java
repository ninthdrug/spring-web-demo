package com.example.demo.models;

import lombok.Value;

import java.util.List;

@Value
public class ElevationInfo {
    @Value
    public static class Location {
        private double lat;
        private double lng;
    }

    @Value
    public static class Elevation {
        private double elevation;
        private Location location;
        private double resolution;
    }

    private String status;
    private List<ElevationInfo.Elevation> results;
}
