package designpatterns.factory_builder;

public class ApplePhone extends Phone {
    @Override
    public void charge() {
        System.out.println(this.getClass().getSimpleName() + "普通充电");
    }
}
