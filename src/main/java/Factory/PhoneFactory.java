package Factory;

public class PhoneFactory {

    public static Phone getPhone(PhoneType phonetype) {

        switch(phonetype) {
            case ANDROID:
                return new AndroidPhone();
            case IPHONE:
                return new Iphone();
                default:
                    return null;
        }
    }
}
