package MedicalChain;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {

        SpringApplication.run(MainApplication.class, args);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Patient patient = context.getBean(Patient.class);
        System.out.println(patient.getGender());
        System.out.println(patient.getMedicalHistory());

    }
}
