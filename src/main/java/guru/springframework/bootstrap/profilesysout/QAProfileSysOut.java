package guru.springframework.bootstrap.profilesysout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("qa")
public class QAProfileSysOut {

    @Autowired
    public QAProfileSysOut(@Value("${guru.springframework.profile.message}") final String message,
                           @Value("${guru.jms.user}") final String user) {
        System.out.println("################################");
        System.out.println("################################");
        System.out.println("##            QA              ##");
        System.out.println(String.format("##       %s      ##", message));
        System.out.println(String.format("##            %s             ##", user));
        System.out.println("################################");
        System.out.println("################################");
    }
}
