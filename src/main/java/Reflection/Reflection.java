package Reflection;

import groovy.lang.Tuple2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Reflection extends Message {

    private Message message = new Messager();

    public Reflection() {}

    public void useReflection() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        Optional<Tuple2<Class<? extends Message>, Method>> handlerOptional = Messager.messagerComponent.getMessageType(message);

        if(handlerOptional.isPresent()) {
            Class<? extends Message> messageType = handlerOptional.get().getFirst();
            Method method = handlerOptional.get().getSecond();
            // TODO If Message type is same as type of Class Message, invoke methods on the target Object
            if (method.getDeclaringClass().getSuperclass() == this.getClass().getSuperclass()) {
                try {
                    // Method invoke needs a static method or you need to create a new instance of the Class Type
                    method.invoke(messageType.newInstance(), "InvokeOnThis");
                    System.out.println("Got inside try block");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Message messager1 = new Messager();
        Oracle oracle = new Oracle();
        Reflection reflection = new Reflection();

        messager1.handlerRegistry.put(oracle.getClass(), oracle.getClass().getDeclaredMethod("stateOfOracle", String.class));

        Method[] methodArray = messager1.getClass().getDeclaredMethods();
        Method[] methodsFromOracle = oracle.getClass().getDeclaredMethods();

        System.out.println("Oracle.class methods: " + Arrays.toString(methodsFromOracle));
        System.out.println("Messager 1 Methods...: " + Arrays.toString(messager1.getClass().getDeclaredMethods()));

        List<Method> streamOfMethods = Arrays.stream(methodArray).filter(x -> x.getName().equals("message2")).collect(Collectors.toList());
        Method methodFromStream = streamOfMethods.get(0);
        methodFromStream.invoke(messager1, "message2(String string) get's immediately invoked!");

        for (Method method : methodArray) {
            if (method.getName().equals("message2")) {
                method.invoke(messager1, "Reached Message 2 with String argument");
            }
        }

        for (Method method : methodsFromOracle) {
            method.invoke(oracle, "String being invoked by Java Reflection API");
        }

        reflection.useReflection();

        }

}
