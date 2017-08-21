package sort;

public class InsertSort {
    public int[] insertSort(int[] array) {
        for (int j = 1; j < array.length; j++) {
            int i = 0;
            while (i <= j && array[j] > array[i]){
                i++;
            }
                

            //            for (int i = 0; i <=j; i++) {
            //                if(array[j]>array[i]){
            if (i < j) {
                int temp = array[j];
                for (int k = j - 1; k >= i; k--) {//1,0
                    array[k + 1] = array[k];
                }
                array[i] = temp;
            }
        }

        //        }
        //    }
        return array;

    }
}
