package sort2;

import util.IUtil;

public class ChooseSort {
public static int[] chooseSort(int[] a){
    for (int i = 0; i < a.length; i++) {
        int k=i;
        for (int j = i; j < a.length; j++) {
            if(a[j]<a[k]){
                k=j;
            }
        }
        IUtil.swap(a, i, k);
    }
    return a;
    
}
public static void main(String[] args) {
    int[] a =IUtil.getNotRepetationRandom(1000, 1000000, 20);
   int[] b= chooseSort(a);
    for (int i = 0; i < b.length; i++) {
        if(i%10==0){
            System.out.println();
        }
        System.out.print(b[i] + " ");
    }
}
}
