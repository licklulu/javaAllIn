package sort;

import util.IUtil;

public class ShellSort {
public static int[] shellSort(int[] a){
   
   
    for (int interval=a.length/2; interval>=1; interval=interval/2) {
        int low=0;
        int high=a.length-1;
        sort(a,low,high,interval);
    }
    return a;
}

private static void sort(int[] a, int low, int high, int interval) {
    for (int j = low+interval; j < high+1; j++) {
        int key=a[j];
        int pre=j-interval;
        while((pre>=low)&&(a[pre]>key)){
//            IUtil.swap(a, pre, j);
            a[pre+interval]=a[pre];
            pre-=interval;
        }
        a[pre+interval]=key;
    }
    
}
public static void main(String[] args) {
    int[] a =IUtil.getNotRepetationRandom(10, 100, 20);
    for (int i = 0; i < a.length; i++) {
        System.out.print(a[i]+" ");
    }
    System.out.println();
   int[] b= shellSort(a);
    for (int i = 0; i < b.length; i++) {
        System.out.print(b[i] + " ");
    }
}
}
