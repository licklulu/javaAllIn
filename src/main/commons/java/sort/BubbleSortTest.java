package sort;

import org.junit.Test;

public class BubbleSortTest {

    @Test
    public void test() {
        int[] array={1,3,5,8,2,4,6};
       HeapSort hp=new HeapSort();
       hp.heapSort(array);
        int key=8;
//        CountSort cs=new CountSort();
//        int[] b=cs.countSort(array, key);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

}
