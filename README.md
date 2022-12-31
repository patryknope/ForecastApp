# Forecast API
This API provides forecast information for the five biggest cities in Poland.

## API Endpoint
The API has a single endpoint, /forecast, which returns a list of forecast objects in JSON format. Each forecast object contains the following fields:

`date`: the date of the forecast

`city`: the city for which the forecast is provided

`maxTemperature`: the maximum temperature for the day

`minTemperature`: the minimum temperature for the day

`averageTemperature`: the average temperature for the day

`averageVisibility`: the average visibility for the day

`maxWindSpeed`: the maximum wind speed for the day

`totalSnow`: the total snowfall for the day

`averageHumidity`: the average humidity for the day
## Usage
To use the API, send a GET request to the /forecast endpoint:

Copy code:

`curl http://localhost:8080/forecast`

The API will return a list of forecast objects in JSON format.

## Dependencies
The API uses the following dependencies:

`Spring Boot`
`OkHttp`
`Jackson`
