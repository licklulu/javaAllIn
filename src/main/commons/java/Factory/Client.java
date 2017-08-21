package Factory;

public class Client {
public static void main(String[] args) {
   Factory bwm530=new CreateBWM530();
   Product p1=bwm530.create();
}
}
