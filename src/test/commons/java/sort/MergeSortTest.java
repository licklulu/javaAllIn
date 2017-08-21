package sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class MergeSortTest {

    @Test
    public void test() {
        int[] a={2,4,6,1,7,5,9,8};
        int left=0;
        int right=a.length-1;
        MergeSort ms=new MergeSort();
        ms.sort(a, left, right);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

}
