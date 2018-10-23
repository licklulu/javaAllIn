package designpatterns.factory_builder;

/**
 * @Auther: lick
 * @Description:
 * @Date:2018/10/22 20:48
 */
public abstract class TV {
    //电视品牌
    private String brand;
    public abstract void play();

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
