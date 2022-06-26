package at.technikum.maintenancemonitor;

import at.technikum.maintenancemonitor.service.MaintanenceMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
abstract class MainController {
    // This abstract class creates and manages a state with the "service" layer.
    // Extend it to create the main controller which should implement the Requestmappings.

   @Autowired
    MaintanenceMonitorService service;

    @RequestMapping("/")
    public String index(Model model) {
        // ModelAndView model contains the attributes passed to the HTML.
        // They are accessible in the HTML file using the name of the attribute.
        model.addAttribute("title", "Maintenance Monitor");
        model.addAttribute("service", service);

        return "index";
    }
}
