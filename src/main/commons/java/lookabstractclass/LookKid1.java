package lookabstractclass;

/**
 * @Auther: lick
 * @Description:
 * @Date:2018/10/27 13:08
 */
public class LookKid1 extends LookParent {
    @Override
    public void say() {
        System.out.println("look kids1");
        LookParent lookParent = new LookParent() {
            @Override
            public void say() {
                System.out.println("look kids2");
            }
        };
        lookParent.say();
    }

    public static void main(String[] args) {
        new LookKid1();

    }
}
