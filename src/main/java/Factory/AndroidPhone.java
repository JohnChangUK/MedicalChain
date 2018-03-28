package Factory;

public class AndroidPhone extends Phone {
    @Override
    protected void createPhone() {
        specifications.add(new AndroidCamera());
        specifications.add(new AndroidPanel());
        specifications.add(new AndroidProcessor());


    }
}
