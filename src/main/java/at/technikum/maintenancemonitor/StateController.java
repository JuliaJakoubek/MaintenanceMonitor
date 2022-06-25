package at.technikum.maintenancemonitor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Timer;
import java.util.TimerTask;

@RestController
public class StateController extends MainController {

    @RequestMapping("/status/set")
    public void setStatus(@RequestParam(name = "status") String status){
        super.service.setStatus(status);
    }


}
