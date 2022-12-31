package com.paszkowski.forecastapp.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ForecastResponse {
    private String city;
    private String date;
    private double maxTemperature;
    private double minTemperature;
    private double averageTemperature;
    private double maxWindSpeed;
    private double totalSnow;
    private double averageVisibility;
    private double averageHumidity;
}
