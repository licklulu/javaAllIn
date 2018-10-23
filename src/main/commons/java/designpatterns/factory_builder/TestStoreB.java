package designpatterns.factory_builder;

/**
 * @Auther: lick
 * @Description:
 * @Date:2018/10/22 21:03
 */
public class TestStoreB {
    public static void main(String[] args) {
        StoreB storeB = new StoreB(new HuaweiFactory());
        Phone phone = storeB.supportPhone();
        phone.charge();
        TV tv = storeB.supportTV();
        tv.play();
    }
}
