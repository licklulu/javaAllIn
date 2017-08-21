package sort;

public class CountSort {
    //key为数组中最大值
public int[] countSort(int[] a,int key){
    int[] b=new int[key+1];
    int length=a.length;
    for (int i = 0; i < a.length; i++) {
        b[a[i]]+=1;//存入每个值的个数
    }
 
    for (int i = 1; i < b.length; i++) {
      b[i]=b[i]+b[i-1];
    }
    int[] aa=new int[length];
    for (int i = length-1; i >=0; i--) {
        aa[b[a[i]]-1]=a[i];
        b[a[i]]--;
    }
    return aa;
}
}
