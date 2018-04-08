package Reflection;

public class Oracle extends Message {

    Oracle() {

    }

    public void calling(String string) {
        System.out.println("Oracle.class: " + string + ", coming from THIS: " + this.getClass().getCanonicalName());
    }

    public void stateOfOracle(String state) {
        System.out.println("The state of the Oracle is : " + state);
    }
}
