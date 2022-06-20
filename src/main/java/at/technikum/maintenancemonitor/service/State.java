package at.technikum.maintenancemonitor.service;

import org.springframework.stereotype.Service;

@Service
public class State {
    // Instantiate variables uptime, downtime, status and message
    private int uptime;
    private int downtime;
    private String status;
    private String message;

    // Constructor
    public State() {
        uptime = 0;
        downtime = 0;
        status = "System is up";
        message = "";
    }

    // Getters and setters
    public int getUptime() {
        return uptime;
    }

    public void setUptime(int uptime) {
        // validate uptime
        if (uptime > 0) {
            this.uptime = uptime;
        }
    }

    public int getDowntime() {
        return downtime;
    }

    public void setDowntime(int downtime) {
        // validate downtime
        if (downtime > 0) {
            this.downtime = downtime;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        // validate input
        if (status.equals("System is up")) {
            this.status = status;
        } else if (status.equals("System is down")) {
            this.status = status;
        } else {
            this.status = "System is up";
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        // validate input for null
        if (message != null) {
            this.message = message;
        }

    }




}
