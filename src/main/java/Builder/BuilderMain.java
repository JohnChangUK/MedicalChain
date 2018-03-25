package Builder;

public class BuilderMain {

    public static void main(String[] args) {

        Phone phoneBuilder = new Phone.Builder()
                                .backPanel("Crystal")
                                .frontPanel("Glass")
                                .camera("12 MegaPixel")
                                .processor("3.7 GHz")
                                .build();

        System.out.println(phoneBuilder);
    }
}
