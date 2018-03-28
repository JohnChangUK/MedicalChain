package AbstractFactory;

public class WindowsFactory implements  OSFactory {
    @Override
    public Phone create(ManufacturerType manufacturerType) {

        switch (manufacturerType) {
            case LENOVO:
                return new LenovoPhone();
            case MICROSOFT:
                return new MicrosoftPhone();
                default:
                    return null;
        }
    }
}
