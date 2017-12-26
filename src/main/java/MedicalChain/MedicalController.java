package MedicalChain;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MedicalController {

    private Map<Integer, String> medicalHistory;

    @RequestMapping("/")
    public List<Patient> getAllPatients() {

        medicalHistory = new HashMap<>();
        medicalHistory.put(1, "James's medical history in a HashMap");

        return Arrays.asList(new Patient(1, "James", 23, "Male", medicalHistory),
        new Patient(2, "Joe", 32, "Male", medicalHistory),
        new Patient(3, "Vicky", 32, "Female", medicalHistory));
    }
}
