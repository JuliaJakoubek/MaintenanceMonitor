package at.technikum.maintenancemonitor.ControllerTests;
import at.technikum.maintenancemonitor.StateController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import at.technikum.maintenancemonitor.service.MaintanenceMonitorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StateControllerTests {
    @Autowired
    public StateController sc;

    @Test
    void testSetState() throws IOException {
        sc.setStatus("System is down");
        assertEquals("System is down", sc.service.getStatus());

        sc.setStatus("System is up");
        assertEquals("System is up", sc.service.getStatus());
    }

    @Test
    void testResetMessage() throws Exception{
        sc.setMessage("testing the reset function.");
        sc.resetMessage();
        assertEquals("Message was reset.", sc.service.getMessage());
    }

    @Test
    void testSetMessage() throws Exception{
        sc.setMessage("The implementation was correct.");
        assertEquals("The implementation was correct.", sc.service.getMessage());
    }

}
