package Factory;

public class CreateBWM531 implements Factory{

    @Override
    public Product create() {
        return new BWM531();
    }

}
