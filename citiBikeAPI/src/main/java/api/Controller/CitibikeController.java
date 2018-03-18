package api.Controller;

import ingester.Model.CitibikeStationsList;
import ingester.Service.CitibikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitibikeController {

    @Autowired
    CitibikeService citibikeService;

    @RequestMapping("/")
    public CitibikeStationsList returnStations() {
        return citibikeService.getCBJson();
    }
}
