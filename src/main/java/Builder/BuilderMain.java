package Builder;

public class BuilderMain {

    public static void main(String[] args) {

        Phone.Builder builder = new Phone.Builder()
                                .backPanel("Crystal")
                                .frontPanel("Glass")
                                .camera("12 MegaPixel")
                                .processor("3.7 GHz");
        
        Phone superPhone = builder.build();

        System.out.println(superPhone);
    }
}
