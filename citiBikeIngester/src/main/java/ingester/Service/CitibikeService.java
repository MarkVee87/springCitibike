package ingester.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import ingester.Model.CitibikeObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;

@Service
public class CitibikeService {

    private CitibikeObject stations;
    private ObjectMapper objectMapper;
    private Long currentTime;

    private HazelcastInstance hazelcastInstance;

    @Autowired
    public CitibikeService(HazelcastInstance hazelcastInstance) {
        this.objectMapper = new ObjectMapper();
        this.stations = getCBJson();
        this.hazelcastInstance = hazelcastInstance;
    }

    public void insertObject() {
        currentTime = System.currentTimeMillis();
        System.out.println("adding objects to HZ");
        hazelcastInstance.getMap("stations").put(currentTime, stations);
    }

    private CitibikeObject getCBJson() {
        if (stations == null) {
            try {
                URL url = new URL("https://feeds.citibikenyc.com/stations/stations.json");
                stations = objectMapper.readValue(url, new TypeReference<CitibikeObject>() {
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stations;
    }

    public CitibikeObject getStations(){
        IMap<Long, CitibikeObject> objects = hazelcastInstance.getMap("stations");
        return objects.get(currentTime);
    }
}