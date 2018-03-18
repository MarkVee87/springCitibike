package ingester.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CitibikeStationsList {

    @JsonProperty("executionTime")
    private String executionTime;

    @JsonProperty("stationBeanList")
    private List<CitibikeStation> stationBeanList = new ArrayList<CitibikeStation>();

    public CitibikeStationsList() {
    }
}