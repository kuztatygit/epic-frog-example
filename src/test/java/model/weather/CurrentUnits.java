package model.weather;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CurrentUnits {
    private String time;
    private String interval;

    @JsonProperty("temperature_2m")
    private String temperature2m;

    private String rain;

    @JsonProperty("is_day")
    private String isDay;
}
