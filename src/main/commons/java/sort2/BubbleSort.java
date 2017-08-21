package sort2;

import util.IUtil;
import util.Util;

public class BubbleSort {
    public static int[] bubbleSort(int[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                  IUtil.swap(a, j, j+1);
                }
            }

        }
        return a;
    }

    public static void main(String[] args) {
        int[] a =IUtil.getNotRepetationRandom(1000, 1000000, 20);
       int[] b= bubbleSort(a);
        for (int i = 0; i < b.length; i++) {
            if(i%10==0){
                System.out.println();
            }
            System.out.print(b[i] + " ");
        }
    }
}
