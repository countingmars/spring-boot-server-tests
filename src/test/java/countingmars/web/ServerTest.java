package countingmars.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServerTest {
    private static String TESTER_ID = UUID.randomUUID().toString();

    @Inject
    private TestRestTemplate testRestTemplate;
    private ServerCaller caller;

    @Before public void before() {
        caller = new ServerCaller(testRestTemplate);
    }

    @Test
    public void testUserShouldBeGreeted() {
        ApiResponse response = caller.get("/" + TESTER_ID, ApiResponse.class).getBody();

        assertEquals(200, response.getHead().getCode());
        assertThat((String) response.getBody(), containsString(TESTER_ID));
    }
}