package com.paszkowski.forecastapp.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastBase {
    private Location location;
    private Forecast forecast;
}