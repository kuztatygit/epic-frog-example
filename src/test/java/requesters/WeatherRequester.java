package requesters;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import model.weather.WeatherResponse;

public class WeatherRequester {
    private final String PREFIX = "https://api.open-meteo.com/v1/forecast?latitude=";
    private final String LON_ATTR = "&longitude=";
    private final String POSTFIX = "&daily=sunrise,sunset,temperature_2m_max,temperature_2m_min,daylight_duration,rain_sum,wind_speed_10m_max&current=temperature_2m,rain,is_day&forecast_days=1";

    public WeatherResponse requestWeather(double lat, double lon) throws JsonProcessingException {
        String url = PREFIX + lat + LON_ATTR + lon + POSTFIX;

        String json= RestAssured.get(url).then().statusCode(200).extract().response().asString();

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, WeatherResponse.class);
    }
}
