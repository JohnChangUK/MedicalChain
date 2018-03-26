package Singleton;

public class SingletonMain {

    public static void main(String[] args) {

        Singleton singleton = Singleton.getSingletonInstance();
        System.out.println(singleton);
        Singleton singleton2 = Singleton.getSingletonInstance();
        System.out.println(singleton2);
    }
}
