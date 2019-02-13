package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Wither;

@Value
@Builder(toBuilder = true)
@Wither
@AllArgsConstructor
public class Coord {
    private double lon;
    private double lat;
}
