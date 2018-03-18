package api.Controller;

import ingester.Model.CitibikeObject;
import ingester.Service.CitibikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitibikeController {

    @Autowired
    CitibikeService citibikeService;

    @RequestMapping("/")
    public CitibikeObject returnStations() {
        citibikeService.insertObject();
        return citibikeService.getStations();
    }
}
