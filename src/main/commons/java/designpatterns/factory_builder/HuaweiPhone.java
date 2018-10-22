package designpatterns.factory_builder;

public class HuaweiPhone extends Phone {
    @Override
    public void charge() {
        System.out.println(this.getClass().getSimpleName() + "快充");
    }
}
