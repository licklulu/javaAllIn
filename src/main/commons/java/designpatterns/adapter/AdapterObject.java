package designpatterns.adapter;

public class AdapterObject implements Target {
    private Target target;
    public AdapterObject(Target target){
        this.target = target;
    }
    @Override
    public void connet(String arg) {
        target.connet(arg);
    }

    public static void main(String[] args) {
        Target adpter = new AdapterObject(new Usb());//通过AdapterObject适配到USB上
        adpter.connet("测试");
    }
}
