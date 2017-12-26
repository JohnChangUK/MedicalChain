package MedicalChain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = "MedicalChain")
public class Config {

    @Bean
    public Integer id() {
        return 1;
    }

    @Bean
    public String name() {
        return "Joe";
    }

    @Bean
    public Integer age() {
        return 32;
    }

    @Bean
    public String gender() {
        return "Male";
    }

    @Bean
    public Map<Integer, String> medicalHistory() {
        Map<Integer, String> medicalHistory = new HashMap<>();
        medicalHistory.put(1, "James's medical history in a HashMap");
        return medicalHistory;
    }

}
