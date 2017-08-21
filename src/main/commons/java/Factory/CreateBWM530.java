package Factory;

public class CreateBWM530 implements Factory{

    @Override
    public Product create() {
        return new BWM530();
    }

}
