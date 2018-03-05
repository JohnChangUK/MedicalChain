package JavaPoet;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class Example {

    public static void main(String[] args) {
        Example tutorial = new Example();
        tutorial.generateJavaSource();
    }

    private void generateJavaSource() {
        MethodSpec constructorSpec = MethodSpec.constructorBuilder()
                .addParameter(TypeName.INT, "aircraftId", Modifier.FINAL)
                .addParameter(String.class, "departure", Modifier.FINAL)
                .addStatement("this.aircraftId = aircraftId")
                .addStatement("this.departure = departure")
                .addModifiers(Modifier.PUBLIC).build();

        MethodSpec getAircraftIdMethod = MethodSpec.methodBuilder("getAircraftId")
                .addModifiers(Modifier.PUBLIC)
                .returns(TypeName.INT)
                .addStatement("return aircraftId")
                .build();

        MethodSpec getDepartureMethod = MethodSpec.methodBuilder("getDeparture")
                .addModifiers(Modifier.PUBLIC)
                .returns(String.class)
                .addStatement("return departure")
                .build();

        FieldSpec timeOfDepartureField = FieldSpec.builder(LocalDateTime.class, "timeOfDeparture", Modifier.PRIVATE)
                .addJavadoc("Time of departure will be set via tower confirmation\n")
                .build();

        MethodSpec takeOffConfirmedMethod = MethodSpec.methodBuilder("takeOffConfirmed")
                .addModifiers(Modifier.PUBLIC)
                .returns(LocalDateTime.class)
                .addStatement("this.$N = $T.now()", timeOfDepartureField, LocalDateTime.class)
                .addStatement("$T.out.println($S)", System.class, "Tower has confirmed takeoff")
                .addStatement("return $N", timeOfDepartureField)
                .build();

        TypeSpec flightPlanSpec = TypeSpec.classBuilder("FlightMsg")
                .addModifiers(Modifier.PUBLIC)
                .addField(TypeName.INT, "aircraftId", Modifier.PRIVATE, Modifier.FINAL)
                .addField(String.class, "departure", Modifier.PRIVATE, Modifier.FINAL)
                .addField(timeOfDepartureField)
                .addMethod(getAircraftIdMethod)
                .addMethod(getDepartureMethod)
                .addMethod(takeOffConfirmedMethod)
                .addMethod(constructorSpec)
                .build();

        JavaFile javaFile = JavaFile.builder("JavaPoet", flightPlanSpec)
                .addFileComment("AUTO_GENERATED by JavaPoet")
                .build();

        try {
            javaFile.writeTo(Paths.get("./src/main/java"));
        } catch (IOException ex) {
            System.out.println("An IO Exception: " + ex.getMessage());
        }
    }
}
