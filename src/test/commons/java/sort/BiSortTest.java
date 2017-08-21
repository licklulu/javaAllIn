package sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class BiSortTest {

    @Test
    public void test() {
        int[] a={1,2,3,4,5,6};
        int x=1;
        BiSort bs=new BiSort();
        int b=bs.biSort(a, x);
        System.out.println(b);
    }

}
