package designpatterns.factory_builder;

public class TestStoreA {
    public static void main(String[] args) {
        //单例获得手机工厂，也可以是单例获得一个手机
        StoreA storeA = new StoreA(SingleProducePhone.INSTANCE.getPhone());
        Phone phone = storeA.supplyPhone();
        phone.charge();
    }
}
