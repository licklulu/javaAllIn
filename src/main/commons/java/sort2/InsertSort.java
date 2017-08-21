package sort2;

import util.IUtil;

public class InsertSort {
public static int[] insertSort(int[] a){
    
    for (int j = 1; j < a.length; j++) {
        int i=0;
        while((i<j)&&(a[j]>a[i])){
            i++;
        }
        int temp=a[j];
        for (int k = j; k >i; k--) {
            IUtil.swap(a, k, k-1);
        }
        a[i]=temp;
    }
    return a;
}
public static void main(String[] args) {
    int[] a =IUtil.getNotRepetationRandom(10, 100, 20);
   int[] b= insertSort(a);
   System.out.println(3/2);
    for (int i = 0; i < b.length; i++) {
        
        System.out.print(b[i] + " ");
    }
}
}
