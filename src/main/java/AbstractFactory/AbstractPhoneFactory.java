package AbstractFactory;

public abstract class AbstractPhoneFactory {

    // Windows Factory
    // Android Factory
    // OS Factory

    // This is the Abstract Factory, which is giving another Factory
    public static OSFactory getFactory(OSType osType) {

        switch (osType) {
            case ANDROID:
                return new AndroidFactory();
            case WINDOWS:
                return new WindowsFactory();
                default:
                    return null;
        }
    }
}
