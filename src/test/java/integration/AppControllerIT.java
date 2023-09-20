package integration;

import org.example.models.TestModel;
import org.example.TestExample;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest(classes = TestExample.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppControllerIT {

    public final TestRestTemplate restTemplate = new TestRestTemplate();

    @LocalServerPort
    private int port;

    @Test
    public void getting_all_models() {
        List<TestModel> testModels = asList(restTemplate.getForObject(
                createURLWithPort("/test", port),
                TestModel[].class));

        assertEquals(2, testModels.size());
    }

    public String createURLWithPort(String uri, int port) {
        return "http://localhost:" + port + uri;
    }
}
