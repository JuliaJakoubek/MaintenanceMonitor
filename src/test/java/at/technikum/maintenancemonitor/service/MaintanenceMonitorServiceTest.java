package at.technikum.maintenancemonitor.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MaintanenceMonitorServiceTest {
    MaintanenceMonitorService service = new MaintanenceMonitorService();
    // write unit tests for the MaintanenceMonitorService class
    // check if the constructor works
    @Test
    public void constructorTest() {
        // expects time in format "%dd %02dh %02dm %02ds"
        assertEquals("0d 00h 00m 00s", service.getDowntime());
        assertEquals("System is up", service.getStatus());
        assertEquals("", service.getMessage());
    }
    // test change methods
    @Test
    public void changeTest() {
        service.setStatus("down");
        service.setMessage("Test");
        assertEquals("System is down", service.getStatus());
        assertEquals("Test", service.getMessage());
    }
    // test if uptime is counting up expects result in format "%dd %02dh %02dm %02ds"
    @Test
    public void uptimeTest() {
        service.changeStatus("up");
        String current = service.getUptime();
      
        // wait for .8 seconds
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        assertTrue(service.getUptime().compareTo(current) > 0);
    }

    // test if downtime is counting up
    @Test
    public void downtimeTest() {
        service.changeStatus("down");
        String current = service.getDowntime();
        // wait for one second
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(service.getDowntime().compareTo(current) > 0);
    }

    // test that uptime stops counting when status is changed to down
    @Test
    public void uptimeStopTest() {
        service.changeStatus("down");
        String current = service.getUptime();
      
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(service.getUptime().compareTo(current) == 0);
    }

    // test reset messages
    @Test
    public void resetTest() {
        service.resetMessage();
        assertEquals("", service.getMessage());
    }

}
