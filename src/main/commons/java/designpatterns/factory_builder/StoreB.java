package designpatterns.factory_builder;

/**
 * @Auther: lick
 * @Description:
 * @Date:2018/10/22 21:00
 */
public class StoreB {
    private Factory factory;
    public StoreB(Factory factory){
        this.factory = factory;
    }
    public Phone supportPhone(){
        return factory.getPhone();
    }
    public TV supportTV(){
        return factory.getTV();
    }
}
