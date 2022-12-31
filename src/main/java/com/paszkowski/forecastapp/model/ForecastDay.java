package com.paszkowski.volvoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastDay {
    private String date;
    private Day day;
}