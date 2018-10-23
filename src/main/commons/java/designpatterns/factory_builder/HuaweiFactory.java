package designpatterns.factory_builder;

public class HuaweiFactory implements Factory {
    @Override
    public Phone getPhone() {
        Phone huawei = new HuaweiPhone();
        huawei.setBrand(PhoneInfo.HUAWEI.getKey());
        huawei.setOs(PhoneInfo.ANDROID.getKey());
        return huawei;
    }

    @Override
    public TV getTV() {
        TV huaweiTV = new HuaweiTV();
        huaweiTV.setBrand(PhoneInfo.HUAWEI.getKey());
        return huaweiTV;
    }
}
