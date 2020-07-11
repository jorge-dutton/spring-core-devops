package guru.springframework.test.external.props;

import guru.springframework.test.jms.FakeJmsBroker;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import guru.test.config.external.props.ExternalPropsEnvironment;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ExternalPropsEnvironment.class)
public class PropertySourceEnvTest {

    @Autowired
    FakeJmsBroker fakeJmsBroker;

    /**
     * Try to test this adding an environment variable "guru.jms.username"
     * with value "something" to check that this test fails because of
     * the properties load precedence in Spring... first env variables
     * for overwriting an already loaded property end then env properties
     * form the properties file.
     */
    @Test
    public void testPropSet() throws Exception {
        Assert.assertEquals("10.10.10.123", fakeJmsBroker.getUrl());
        Assert.assertEquals(3330, fakeJmsBroker.getPort().intValue());
        Assert.assertEquals("Ron", fakeJmsBroker.getUser());
        Assert.assertEquals("Burgundy", fakeJmsBroker.getPassword());
    }
}
