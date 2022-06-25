package at.technikum.maintenancemonitor.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaintanenceMonitorServiceTest {
    MaintanenceMonitorService service = new MaintanenceMonitorService();
    // write unit tests for the MaintanenceMonitorService class
    // check if the constructor works
    @Test
    public void constructorTest() {
        assertEquals(0, service.getUptime());
        assertEquals(0, service.getDowntime());
        assertEquals("System is up", service.getStatus());
        assertEquals("", service.getMessage());
    }
    // test change methods
    @Test
    public void changeTest() {
        service.changeStatus("down");
        service.changeMessage("Test");
        assertEquals("System is down", service.getStatus());
        assertEquals("Test", service.getMessage());
    }
    // test if uptime is counting up
    @Test
    public void uptimeTest() {
        service.start();
        service.changeStatus("up");
        // wait for .8 seconds
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(1, service.getUptime());
        // check uptime after 3 seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(4, service.getUptime());
    }

    // test if downtime is counting up
    @Test
    public void downtimeTest() {
        service.start();
        service.changeStatus("down");
        // wait for one second
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(1, service.getDowntime());
        // check downtime after 3 seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(4, service.getDowntime());
    }

    // test reset messages
    @Test
    public void resetTest() {
        service.resetMessage();
        assertEquals("", service.getMessage());
    }


}
