package guru.springframework.bootstrap.profilesysout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
public class DefaultProfileSysOut {

    /**
     * We have to define the property value as a constructor param for this
     * to work properly
     * @param message
     */
    @Autowired
    public DefaultProfileSysOut(@Value("${guru.springframework.profile.message}") final String message) {
        System.out.println("################################");
        System.out.println("################################");
        System.out.println("##           DEFAULT          ##");
        System.out.println(message);
        System.out.println("################################");
        System.out.println("################################");
    }
}
