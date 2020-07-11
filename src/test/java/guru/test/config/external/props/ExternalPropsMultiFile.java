package guru.test.config.external.props;

import guru.springframework.test.jms.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * This configurations illustrates how to use multiple properties
 * file in one configuration class
 */

@Configuration
@PropertySource({"classpath:testing.properties", "classpath:encrypted-test.properties"})
public class ExternalPropsMultiFile {

    @Autowired
    Environment env;

    @Bean
    FakeJmsBroker fakeJmsBrokerMulti() {
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUrl(env.getProperty("guru.jms.server"));
        fakeJmsBroker.setPort(env.getRequiredProperty("guru.jms.port", Integer.class));
        fakeJmsBroker.setUser(env.getProperty("guru.jms.user"));
        fakeJmsBroker.setPassword(env.getProperty("guru.jms.encrypted.password"));
        return fakeJmsBroker;
    }
}
