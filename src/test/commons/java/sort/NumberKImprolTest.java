package sort;

import org.junit.Test;

public class NumberKImprolTest {

    @Test
    public void test() {
        int[] array={1,3,5,8,2,4,6};
        int begin=0;
        int end=array.length-1;
        int k=5;
        NumberKImprol nk=new NumberKImprol();
        int a= nk.numerKImprol(array, begin, end, k);
       System.out.println("第K大的数为："+a);
    }

}
