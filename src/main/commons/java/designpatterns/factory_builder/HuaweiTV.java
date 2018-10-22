package designpatterns.factory_builder;

/**
 * @Auther: lick
 * @Description:
 * @Date:2018/10/22 20:51
 */
public class HuaweiTV extends TV{
    @Override
    public void play() {
        System.out.println(this.getClass().getSimpleName() + "华为电视");
    }
}
