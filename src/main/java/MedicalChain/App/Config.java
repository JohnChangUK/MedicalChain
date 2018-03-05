package MedicalChain.App;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = "MedicalChain.App")
public class Config {

    private Map<Integer, String> medicalHistory;

    @Bean
    public Map<Integer, String> medicalHistory() {
        medicalHistory = new HashMap<>();
        medicalHistory.put(1, "Patient1 medical History");
        return medicalHistory;
    }

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

}
