package AbstractFactory;

public interface OSFactory {

    Phone create(ManufacturerType manufacturerType);
}
