package designpatterns.factory_builder;

public enum PhoneInfo {
    HUAWEI("huawei"),
    APPLE("apple"),
    ANDROID("android"),
    IOS("ios");
    private String key;
    PhoneInfo(String key){
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
