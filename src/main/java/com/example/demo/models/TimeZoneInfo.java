package com.example.demo.models;

import lombok.Value;

@Value
public class TimeZoneInfo {
    private int dstOffset;
    private int rawOffset;
    private String status;
    private String timeZoneId;
    private String timeZoneName;
}
