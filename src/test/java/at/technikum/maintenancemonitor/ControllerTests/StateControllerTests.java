package at.technikum.maintenancemonitor.ControllerTests;
import at.technikum.maintenancemonitor.StateController;
import at.technikum.maintenancemonitor.service.MaintanenceMonitorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({StateController.class})
public class StateControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MaintanenceMonitorService service;

    @Test
    public void testStateUp() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/status/set")
                        .param("status", "up")
        ).andExpect(status().isOk()).andExpect(content().string("Status set to: up"));

    }

    @Test
    public void testStateDown() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/status/set")
                        .param("status", "down")
        ).andExpect(status().isOk()).andExpect(content().string("Status set to: down"));

    }

    @Test
    public void testStateInvalid() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/status/set")
                        .param("status", "invalid")
        ).andExpect(status().isOk()).andExpect(content().string("Status set to: invalid"));

    }

    @Test
    public void testMessageReset() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/status/message/reset")
        ).andExpect(status().isOk()).andExpect(content().string("Message was reset."));

    }

    @Test
    public void testMessageSet() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/status/message")
                        .param("message", "Test")
        ).andExpect(status().isOk()).andExpect(content().string("Message set to: Test"));

    }



}
