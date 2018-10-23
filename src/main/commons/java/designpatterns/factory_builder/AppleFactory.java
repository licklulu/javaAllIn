package designpatterns.factory_builder;

public class AppleFactory implements Factory {
    @Override
    public Phone getPhone() {
        Phone apple = new ApplePhone();
        apple.setBrand(PhoneInfo.APPLE.getKey());
        apple.setOs(PhoneInfo.IOS.getKey());
        return apple;
    }

    @Override
    public TV getTV() {
        TV appleTV = new AppleTV();
        appleTV.setBrand(PhoneInfo.APPLE.getKey());
        return appleTV;
    }
}
