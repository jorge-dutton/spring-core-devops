package guru.springframework.test.dstest;

import guru.springframework.SpringCoreDevOpsApplication;
import guru.springframework.test.config.DataSourceConfig;
import guru.springframework.test.ds.FakeDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DataSourceConfig.class)
//@ActiveProfiles("prod")
public class DataSourceTest {

    private Logger log = LoggerFactory.getLogger(DataSourceTest.class);

    private FakeDataSource fakeDataSource;

    @Autowired
    public void setFakeDataSource(final FakeDataSource fakeDataSource) {
        this.fakeDataSource = fakeDataSource;
    }

    @Test
    public void testDataSource() throws Exception {
        log.info(fakeDataSource.getConnectionInfo());
    }
}
