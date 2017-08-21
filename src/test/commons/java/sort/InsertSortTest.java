package sort;

import org.junit.Test;

public class InsertSortTest {
@Test
    public void test() {
        int[] array={1,3,5,8,2,4,6};
        InsertSort is=new InsertSort();
       is.insertSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

}
