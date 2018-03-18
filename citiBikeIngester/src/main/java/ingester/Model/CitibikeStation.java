package ingester.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CitibikeStation {

    @JsonProperty("id")
    private int id;

    @JsonProperty("stationName")
    private String stationName;

    public CitibikeStation() {
    }
}