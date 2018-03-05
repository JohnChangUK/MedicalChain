package JavaPoet;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Person p = new Person("Peter");

        try {
            Field field = p.getClass().getDeclaredField("name");
            field.setAccessible(true);
            System.out.println(field.get(p));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Field field = Person.class.getDeclaredField("numPeople");
            field.setAccessible(true);
            System.out.println(field.get(null));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Method method = p.getClass().getDeclaredMethod("getName");
            System.out.println(method.invoke(p));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Method method = p.getClass().getDeclaredMethod("setName", String.class);
            method.invoke(p, "James Altucher");
            System.out.println(p.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Method method = Person.class.getDeclaredMethod("printPerson", Person.class);
            method.invoke(null, p);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Person other = new Person("Other");
        Person.printPerson(other);

        try {
            Constructor<Person> constructor = Person.class.getDeclaredConstructor(String.class);
            other = constructor.newInstance("ChangedPerson");
            Person.printPerson(other);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Class c = Person.class;
        String nameOfClass = c.getName();
        System.out.println(nameOfClass);
        Method[] methods = Person.class.getMethods();
        Arrays.stream(methods).forEach(System.out::println);

        Constructor[] constructorsArray = Person.class.getConstructors();
        Arrays.stream(constructorsArray).forEach(System.out::println);

        Field[] fieldsArray = Person.class.getFields();
        Arrays.stream(fieldsArray).forEach(System.out::println);

    }
}
