package com.paszkowski.forecastapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paszkowski.forecastapp.model.ForecastDay;
import com.paszkowski.forecastapp.model.ForecastBase;
import com.paszkowski.forecastapp.model.ForecastResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForecastService {

    private static final String API_ENDPOINT = "https://api.weatherapi.com/v1/forecast.json";
    private static final String API_KEY = "b7213ff5d46f45a480b144236223012";
    private static final int DAY_COUNT = 7;

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<ForecastResponse> getForecast(String city) throws Exception {
        ForecastBase forecast = getWeather(city);
        List<ForecastDay> forecastDayList = forecast.getForecast().getForecastDayList();
        return forecastDayList.stream()
                .map(forecastDay -> ForecastResponse.builder()
                        .date(forecastDay.getDate())
                        .city(city)
                        .maxTemperature(forecastDay.getDay().getMaxTemperature())
                        .minTemperature(forecastDay.getDay().getMinTemperature())
                        .averageTemperature(forecastDay.getDay().getAverageTemperature())
                        .averageVisibility(forecastDay.getDay().getAverageVisibility())
                        .maxWindSpeed(forecastDay.getDay().getMaxWindSpeed())
                        .totalSnow(forecastDay.getDay().getTotalSnow())
                        .averageHumidity(forecastDay.getDay().getAverageHumidity())
                        .build())
                .collect(Collectors.toList());
    }

    private ForecastBase getWeather(String city) throws Exception {
        String url = buildUrl(city);
        Request request = new Request.Builder().url(url).build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful() || response.body() == null) {
                throw new Exception("Failed to get forecast: " + response);
            }
            return objectMapper.readValue(response.body().string(), ForecastBase.class);
        }
    }

    private String buildUrl(String city) {
        return API_ENDPOINT + "?key=" + API_KEY + "&q=" + city + "&days=" + DAY_COUNT + "&aqi=no&alerts=no";
    }
}