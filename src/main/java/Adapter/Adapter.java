package Adapter;

public class Adapter {

    public static void main(String[] args) {
        GooglePixelCharger googlePixelCharger = new GooglePixelCharger();
        GooglePixel googlePixel = new GooglePixel();
        googlePixelCharger.charge(googlePixel);

        IphoneCharger iphoneCharger = new IphoneCharger();
        Iphone iphone = new IphoneX();
        iphoneCharger.charge(iphone);

        AndroidToIPhoneAdapter androidToIPhoneAdapter = new AndroidToIPhoneAdapter(googlePixel);
        iphoneCharger.charge(androidToIPhoneAdapter);

    }
}
