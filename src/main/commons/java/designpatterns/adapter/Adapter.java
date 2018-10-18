package designpatterns.adapter;

public class Adapter extends PS2 implements Target{
    public void connet(String arg) {
        super.connect(arg);//PS2能够实现USB的功能
    }

    public static void main(String[] args) {
        Target target = new Usb();
        target.connet("测试");
    }
}
