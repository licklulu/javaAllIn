package designpatterns.factory_builder;

public enum  SingleProducePhone {
    INSTANCE;//为一个phoneFactory
    private Factory phoneFactory;
    SingleProducePhone(){
        phoneFactory = new HuaweiFactory();
    }
    public Factory getPhone(){
        return phoneFactory;
    }
}
