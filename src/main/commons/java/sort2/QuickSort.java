package sort2;

import util.IUtil;

public class QuickSort {
public static int getPartion(int[] a,int low,int high){
    int key=a[low];
    while(low<high){
        while((low<high)&&(a[high]>key))
            high--;
        a[low]=a[high];
        while((low<high)&&(a[low]<key))
            low++;
        a[high]=a[low];
    }
    a[high]=key;
    return high;
}
public static int[] quickSort(int[] a,int low,int high){
    int m=getPartion(a,low,high);
    if(m>low){
         quickSort(a,low,m-1);
    }
    if(m<high){
        quickSort(a,m+1,high);
    }
    return a;
}
public static void main(String[] args) {
    int[] a =IUtil.getRandom(10, 100, 20);
    for (int i = 0; i < a.length; i++) {
        System.out.print(a[i]+" ");
    }
    System.out.println();
    int low=0;
    int high=a.length-1;
   int[] b= quickSort(a,low,high);
    for (int i = 0; i < b.length; i++) {
        System.out.print(b[i] + " ");
    }
}
}
