package at.technikum.maintenancemonitor.service;

import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.TimerTask;

@Service
public class MaintanenceMonitorService {
    // instantiate state
    private State state = new State();
    // instantiate Timer
    private Timer timer = new Timer();

    // if status is up, count uptime up by 1 every second
    // if status is down, count downtime up by 1 every second
    public void start() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (state.getStatus().equals("System is up")) {
                    state.setUptime(state.getUptime() + 1);
                } else {
                    state.setDowntime(state.getDowntime() + 1);
                }
            }
        }, 0, 1000);
    }

    // change status on
    public void changeStatus(String status) {
        //validate status
        if (status.equals("up")) {
            state.setStatus("System is " + status);
        } else if (status.equals("down")) {
            state.setStatus("System is " + status);
        }
    }

    // read downtime
    public int getDowntime() {
        return state.getDowntime();
    }

    // read uptime
    public int getUptime() {
        return state.getUptime();
    }

    // read status
    public String getStatus() {
        return state.getStatus();
    }

    // read message
    public String getMessage() {
        return state.getMessage();
    }

    // set message
    public void changeMessage(String message) {
        state.setMessage(message);
    }

    // reset message
    public void resetMessage() {
        state.setMessage("");
    }

}
