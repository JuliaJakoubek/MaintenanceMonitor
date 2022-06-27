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

    @Test
    void testPostMapping() throws IOException {
        URL url = new URL("http://localhost:8080/status/set");
        HttpURLConnection httpURLConnection;
        try{
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
        } catch(Exception e){
            System.out.print("Not on localhost, therefore tests disabled");
            return;
        }

        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        String testString = "Test";

        try (OutputStream outputStream = httpURLConnection.getOutputStream()) {
            outputStream.write(testString.getBytes());
            outputStream.flush();
        }

        int responseCode = httpURLConnection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            System.out.println("GET Response Code :: " + responseCode);
        }
        else {
            System.out.println("Connection failed!");
        }
    }


    @Autowired
    public StateController sc;


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
