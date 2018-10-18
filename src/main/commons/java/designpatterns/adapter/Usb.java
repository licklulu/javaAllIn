package designpatterns.adapter;

public class Usb implements Target{
    public void connet(String arg) {
        System.out.println(arg + "USB");
    }
}
