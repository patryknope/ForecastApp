package com.paszkowski.volvoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
    @JsonProperty("forecastday")
    private List<ForecastDay> forecastDayList;
}