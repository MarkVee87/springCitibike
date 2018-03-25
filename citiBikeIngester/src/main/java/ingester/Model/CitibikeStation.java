package ingester.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CitibikeStation implements Serializable {

    @JsonProperty("id")
    private int id;

    @JsonProperty("stationName")
    private String stationName;

    public CitibikeStation() {
    }
}