package Factory;

public class FactoryApp {

    public static void main(String[] args) {

        Phone androidPhone = PhoneFactory.getPhone(PhoneType.ANDROID);
        Phone iPhone = PhoneFactory.getPhone(PhoneType.IPHONE);
        Phone iPhone2 = PhoneFactory.getPhone(PhoneType.IPHONE);

        System.out.println(androidPhone);
        System.out.println(iPhone);
        System.out.println(iPhone2);
    }
}
