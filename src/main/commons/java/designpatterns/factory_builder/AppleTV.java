package designpatterns.factory_builder;

/**
 * @Auther: lick
 * @Description:
 * @Date:2018/10/22 20:50
 */
public class AppleTV extends TV {
    @Override
    public void play() {
        System.out.println(this.getClass().getSimpleName() + "苹果电视");
    }
}
