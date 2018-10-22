package designpatterns.factory_builder;

public abstract class Phone {
    //品牌
    private String brand;
    //操作系统
    private String os;
    public abstract void charge();

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }
}
