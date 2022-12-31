package com.paszkowski.volvoapp.controller;

import com.paszkowski.volvoapp.model.ForecastResponse;
import com.paszkowski.volvoapp.service.ForecastService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ForecastController {
    private static final List<String> BIGGEST_CITIES = List.of("Warsaw", "Krakow", "Lodz", "Wroclaw", "Poznan");
    private final ForecastService forecastService;


    public ForecastController(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    @GetMapping("/forecast")
    @ApiOperation("get forecast for 5 biggest cities in Poland")
    public List<ForecastResponse> getForecast() {
        return BIGGEST_CITIES.stream()
                .flatMap(city -> {
                    try {
                        return forecastService.getForecast(city).stream();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
    }
}
