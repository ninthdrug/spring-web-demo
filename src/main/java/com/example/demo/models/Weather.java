package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Wither;

@Value
@Builder(toBuilder = true)
@Wither
@AllArgsConstructor
public class Weather {
    private long id;
    private String main;
    private String description;
    private String icon;
}
