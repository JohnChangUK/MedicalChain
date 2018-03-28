package AbstractFactory;

public class AndroidFactory implements OSFactory {
    @Override
    public Phone create(ManufacturerType manufacturerType) {

        switch (manufacturerType) {
            case GOOGLE:
                return new GooglePhone();
            case ONEPLUS:
                return new OnePlus();
                default:
                    return null;
        }
    }
}
