package Reflection;

import groovy.lang.Tuple2;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Optional;

public abstract class Message {

    Map<Class<? extends Message>, Method> handlerRegistry;

    public void parentClassMethod() {
        System.out.println("Parent class Message");
    }

    public Map<Class<? extends Message>, Method> getHandlerRegistry() {
        return handlerRegistry;
    }

    public void setHandlerRegistry(Map<Class<? extends Message>, Method> handlerRegistry) {
        this.handlerRegistry = handlerRegistry;
    }

    public Optional<Tuple2<Class<? extends Message>, Method>> getMessageType(Message message) throws NoSuchMethodException {
        Message messager1 = new Messager();
        Oracle oracle = new Oracle();
        messager1.handlerRegistry.put(oracle.getClass(), oracle.getClass().getDeclaredMethod("stateOfOracle", String.class));

        for (Class<? extends Message> singleMessage : messager1.handlerRegistry.keySet()) {
            if (Message.class.isInstance(message)) {
                return Optional.of(new Tuple2<>(singleMessage, messager1.handlerRegistry.get(singleMessage)));
            }
        }
        return Optional.empty();
    }
}
