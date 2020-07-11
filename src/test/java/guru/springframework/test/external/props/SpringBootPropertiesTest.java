package guru.springframework.test.external.props;

import guru.springframework.SpringCoreDevOpsApplication;
import guru.springframework.test.jms.FakeJmsBroker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 *  WARNING!
 *  Actually this test has to bring up the whole Spring Boot context, tomcat, Jms
 *  everything, just for testing for the properties file.
 *  This is not a proper integration test, but it is implemented so you can see how
 *  things must be done for making this kind of tests in Spring Boot.
 *  So this is not the way to make an integration test in Spring Boot
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringCoreDevOpsApplication.class)
// @WebIntegrationTest Is mandatory to bring up the application.properties config file
@WebIntegrationTest
// With @testPropertySource annotation things work different regarding properties
// hierarchy. In this case the file takes precedence over everything else,
// even environment variables
@TestPropertySource("/application.properties")
public class SpringBootPropertiesTest {

    @Autowired
    FakeJmsBroker fakeJmsBroker;

    @Test
    public void testPropSet() throws Exception {
        assertEquals("10.10.10.123", fakeJmsBroker.getUrl());
        assertEquals(3330, fakeJmsBroker.getPort().intValue());
        assertEquals("Ron", fakeJmsBroker.getUser());
        assertEquals("Burgundy", fakeJmsBroker.getPassword());
    }
}
