package Adapter;

public class AndroidToIPhoneAdapter implements Iphone {

    private Android android;

    public AndroidToIPhoneAdapter(Android android) {
        this.android = android;
    }

    public void charge() {
        System.out.println("Supporting both Android AND iPhone");
        android.charge();
    }
}
