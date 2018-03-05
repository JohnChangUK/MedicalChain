package JavaPoet;

public class Person {

    private String name;

    public String publicNameField;

    private static int numPeople = 0;

    public Person(String name) {
        this.name = name;

        numPeople++;
    }

    public Person(String name, int numPeople) {
        System.out.println(name + numPeople);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void printPerson(Person p) {
        System.out.println(p.getName());
    }
}
