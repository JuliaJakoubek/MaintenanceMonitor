package at.technikum.maintenancemonitor.ControllerTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import at.technikum.maintenancemonitor.service.MaintanenceMonitorService;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import java.io.IOException;


public class StateControllerTests {

    @Test
    void testPostMapping() throws IOException {
        URL url = new URL("http://localhost:8080/status/set");
        HttpURLConnection httpURLConnection;
        try{
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
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
}
