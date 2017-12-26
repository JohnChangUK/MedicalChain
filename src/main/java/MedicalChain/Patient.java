package MedicalChain;

import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Builder(toBuilder = true)
public class Patient {

    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private Map<Integer, String> medicalHistory;

    public Patient() {}

    @Autowired
    public Patient(Integer id, String name, Integer age, String gender, Map<Integer, String>medicalHistory) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.medicalHistory = medicalHistory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<Integer, String> getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(Map<Integer, String> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id &&
                age == patient.age &&
                com.google.common.base.Objects.equal(name, patient.name) &&
                com.google.common.base.Objects.equal(gender, patient.gender) &&
                com.google.common.base.Objects.equal(medicalHistory, patient.medicalHistory);
    }

    @Override
    public int hashCode() {
        return com.google.common.base.Objects.hashCode(id, name, age, gender, medicalHistory);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", medicalHistory=" + medicalHistory +
                '}';
    }
}
