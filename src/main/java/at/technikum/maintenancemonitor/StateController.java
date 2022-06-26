package at.technikum.maintenancemonitor;

import at.technikum.maintenancemonitor.service.MaintanenceMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateController {

    @Autowired
    MaintanenceMonitorService service;
    //Sets status with Request with method from Superclass
    @PostMapping("/status/set")
    public String setStatus(@RequestParam(name = "status") String status){
        service.setStatus(status);
        return "Status set to: " + status;
    }
}
