package AbstractFactory;

public class AbstractFactoryExample {

    public static void main(String[] args) {

        OSFactory osFactory = AbstractPhoneFactory.getFactory(OSType.ANDROID);
        Phone googlePixel = osFactory.create(ManufacturerType.GOOGLE);
        googlePixel.display();

        OSFactory windows = AbstractPhoneFactory.getFactory(OSType.WINDOWS);
        Phone nokiaMicrosoft = windows.create(ManufacturerType.MICROSOFT);
        nokiaMicrosoft.display();
    }
}
