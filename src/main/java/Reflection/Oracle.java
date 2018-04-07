package Reflection;

public class Oracle {

    Oracle() {

    }

    public void calling(String string) {
        System.out.println("Oracle.class: " + string + ", coming from THIS: " + this);
    }

    public void stateOfOracle(String state) {
        System.out.println("The state of the Oracle is : " + state);
    }
}
