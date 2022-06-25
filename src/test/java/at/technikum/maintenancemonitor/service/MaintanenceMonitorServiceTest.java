package at.technikum.maintenancemonitor.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaintanenceMonitorServiceTest {
    MaintanenceMonitorService service = new MaintanenceMonitorService();
    // write unit tests for the MaintanenceMonitorService class
    // check if the constructor works
    @Test
    public void constructorTest() {
        // expects time in format "%dd %02dh %02dm %02ds"
        assertEquals("0d 00h 00m 00s", service.getUptime());
        assertEquals("0d 00h 00m 00s", service.getDowntime());
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
    // test if uptime is counting up expects result in format "%dd %02dh %02dm %02ds"
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

        assertEquals("0d 00h 00m 01s", service.getUptime());
        // check uptime after 3 seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("0d 00h 00m 04s", service.getUptime());
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
        assertEquals("0d 00h 00m 01s", service.getDowntime());
        // check downtime after 3 seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("0d 00h 00m 04s", service.getDowntime());
    }

    // test that uptime stops counting when status is changed to down
    @Test
    public void uptimeStopTest() {
        service.start();
        // wait for one second
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.changeStatus("down");
        // wait for one second
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("0d 00h 00m 01s", service.getUptime());
    }

    // test reset messages
    @Test
    public void resetTest() {
        service.resetMessage();
        assertEquals("", service.getMessage());
    }

}
