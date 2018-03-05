package MedicalChain.App;

import org.springframework.stereotype.Component;

@Component
public class Patient1 implements History {

    public void patient() {
        System.out.println("Here is Patient 1's information");
    }
}
