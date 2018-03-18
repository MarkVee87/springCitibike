package ingester.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ingester.Model.CitibikeStationsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;

@Service
public class CitibikeService {

    private CitibikeStationsList stations;
    private ObjectMapper objectMapper;

    @Autowired
    public CitibikeService() {
        this.objectMapper =  new ObjectMapper();
    }

    public CitibikeStationsList getCBJson() {
        try {
            URL url = new URL("https://feeds.citibikenyc.com/stations/stations.json");
            stations = objectMapper.readValue(url, new TypeReference<CitibikeStationsList>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stations;
    }
}