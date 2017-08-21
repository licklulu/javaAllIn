package sort2;

import util.IUtil;

public class CountSort {
    //key为a数组中最大值
public static int[] countSort(int[] a,int key){
    int[] b=new int[key+1];
    for (int i = 0; i < a.length; i++) {
        b[a[i]]+=1;
    }
    int[] temp=new int[a.length];
    int k=0;
  for (int i = 0; i < b.length; i++) {
      if(k<a.length){
    while(b[i]>0){
     temp[k]=i;
     k++;
     b[i]--;
    }
      }
}
  return temp;
}
public static void main(String[] args) {
    int[] a=IUtil.getRandom(7, 20, 1);
    for (int i = 0; i < a.length; i++) {
        System.out.print(a[i]+" ");
    }
    System.out.println();
  int[]  temp= countSort(a,20);
    for (int i = 0; i < temp.length; i++) {
        System.out.print(temp[i]+" ");
    }
}
}
