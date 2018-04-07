package Reflection;

import java.util.LinkedHashMap;

public class Messager extends Message {

    static final Messager messagerComponent = new Messager();

    Messager() {
        super();
        handlerRegistry = new LinkedHashMap<>();
    }

    public void message() {
        System.out.println("Coming from Messager Class: " + this);
    }

    public void message2(String string) {
        System.out.println("reached message2 Method in Messager.class: " + string + ", coming from THIS: " + this);
    }

}
