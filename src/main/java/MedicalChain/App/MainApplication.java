package MedicalChain.App;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class MainApplication {

    @Qualifier("patient")
    private static Patient patient;

    public static void main(String[] args) {

        SpringApplication.run(MainApplication.class, args);

        AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext(Config.class);
        patient = factory.getBean(Patient.class);
        patient.history();


    }
}
