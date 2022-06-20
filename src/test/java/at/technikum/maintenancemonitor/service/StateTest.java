package at.technikum.maintenancemonitor.service;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StateTest {
    // Write unit tests for the State class
    // Check if the constructor works
    State state = new State();
    @Test
    public void constructorTest() {
        assertEquals(0, state.getUptime());
        assertEquals(0, state.getDowntime());
        assertEquals("System is up", state.getStatus());
        assertEquals("", state.getMessage());
    }
    // Check if the setters work
    @Test
    public void setterTest() {
        state.setUptime(1);
        state.setDowntime(1);
        state.setStatus("System is down");
        state.setMessage("Test");
        assertEquals(1, state.getUptime());
        assertEquals(1, state.getDowntime());
        assertEquals("System is down", state.getStatus());
        assertEquals("Test", state.getMessage());
    }
    // Check if the getters work
    @Test
    public void getterTest() {
        state.setUptime(1);
        state.setDowntime(1);
        state.setStatus("System is down");
        state.setMessage("Test");
        assertEquals(1, state.getUptime());
        assertEquals(1, state.getDowntime());
        assertEquals("System is down", state.getStatus());
        assertEquals("Test", state.getMessage());
    }
    // Check setters with negative values
    @Test
    public void setterNegativeTest() {
        state.setUptime(-1);
        state.setDowntime(-1);
        state.setStatus("System is down");
        state.setMessage("");
        assertEquals(0, state.getUptime());
        assertEquals(0, state.getDowntime());
        assertEquals("System is down", state.getStatus());
        assertEquals("", state.getMessage());
    }
    // Check setters with invalid values
    @Test
    public void setterInvalidTest() {
        state.setUptime(1);
        state.setDowntime(1);
        state.setStatus("System is down");
        state.setMessage(null);
        assertEquals(1, state.getUptime());
        assertEquals(1, state.getDowntime());
        assertEquals("System is down", state.getStatus());
        assertEquals("", state.getMessage());
    }

}
