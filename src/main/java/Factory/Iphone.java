package Factory;

public class Iphone extends Phone {
    @Override
    protected void createPhone() {
        specifications.add(new IphoneCamera());
        specifications.add(new IphonePanel());
        specifications.add(new IphoneProcessor());
    }
}
