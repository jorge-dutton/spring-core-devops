package guru.springframework.test.ds;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProdDataSource implements FakeDataSource{
    @Override
    public String getConnectionInfo() {
      return "I am the Production DataSource";
    }
}
