package org.example.hotelmanagmentsystem.services;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherService {

    private static final String API_URL = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/54.830499,18.308731?unitGroup=metric&include=current&key=VE4UHM89AG3XN7UF6RUKHBKM9&contentType=json";

    public Map<String, Object> getWeather() {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> response = restTemplate.getForObject(API_URL, Map.class);

        Map<String, Object> currentConditions = (Map<String, Object>) response.get("currentConditions");

        Map<String, Object> filteredWeather = new HashMap<>();
        filteredWeather.put("temp", currentConditions.get("temp"));
        filteredWeather.put("feelslike", currentConditions.get("feelslike"));
        filteredWeather.put("humidity", currentConditions.get("humidity"));
        filteredWeather.put("conditions", currentConditions.get("conditions"));

        return filteredWeather;

    }
}
