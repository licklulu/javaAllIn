package proxy;

public class RealSubject implements Subject{

    @Override
    public int doSomething() {
        return 1;
    }

}
