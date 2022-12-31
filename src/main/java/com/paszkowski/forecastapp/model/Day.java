package com.paszkowski.volvoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Day {
    @JsonProperty("maxtemp_c")
    private double maxTemperature;
    @JsonProperty("mintemp_c")
    private double minTemperature;
    @JsonProperty("avgtemp_c")
    private double averageTemperature;
    @JsonProperty("maxwind_kph")
    private double maxWindSpeed;
    @JsonProperty("totalsnow_cm")
    private double totalSnow;
    @JsonProperty("avgvis_km")
    private double averageVisibility;
    @JsonProperty("avghumidity")
    private double averageHumidity;
}