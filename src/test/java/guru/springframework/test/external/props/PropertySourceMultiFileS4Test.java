package guru.springframework.test.external.props;

import guru.springframework.test.jms.FakeJmsBroker;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import guru.test.config.external.props.ExternalPropsMultiFileS4;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ExternalPropsMultiFileS4.class)
public class PropertySourceMultiFileS4Test {

    @Autowired
    FakeJmsBroker fakeJmsBroker;

    @Test
    public void testPropSet() throws Exception {
        Assert.assertEquals("10.10.10.123", fakeJmsBroker.getUrl());
        Assert.assertEquals(3330, fakeJmsBroker.getPort().intValue());
        Assert.assertEquals("Ron", fakeJmsBroker.getUser());
        Assert.assertEquals("%ty*)(*er", fakeJmsBroker.getPassword());
    }
}
