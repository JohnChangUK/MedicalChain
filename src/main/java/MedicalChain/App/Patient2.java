package MedicalChain.App;

import org.springframework.stereotype.Component;

@Component
public class Patient2 implements History {

    public void patient() {
        System.out.println("Patient 2's History, regarding Health");
    }
}
