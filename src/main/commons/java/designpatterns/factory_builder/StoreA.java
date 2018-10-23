package designpatterns.factory_builder;

public class StoreA {
    private Factory phoneFactory;
    public  StoreA(Factory phoneFactory){
        this.phoneFactory = phoneFactory;
    }
    public  Phone supplyPhone(){
        System.out.println("手机补充完成");
        return phoneFactory.getPhone();
    }

}
