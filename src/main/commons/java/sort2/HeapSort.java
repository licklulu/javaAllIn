package sort2;

import util.IUtil;
/**
 * 数组上模拟的堆，空间复杂度为O（1）
 * @author Administrator
 *
 */
public class HeapSort {
public static void heapSort(int[] a){
    buildHeap(a);
    for (int i = a.length-1; i >=0; i--) {
        IUtil.swap(a, i, 0);
        recoverHeap(a, i, 0);
    }
}
public static void buildHeap(int[] a){
    int half=a.length/2;
    for (int i = half; i >=0; i--) {
        recoverHeap(a, a.length, i);
    }
}
public static void recoverHeap(int[]a,int heapSize,int index){
    int largest=index;
    int left=2*index+1;
    int right=2*index+2;
    if((left<heapSize)&&(a[left]>a[largest])){
        largest=left;
    }
    if((right<heapSize)&&(a[right]>a[largest])){
        largest=right;
    }
    if(index!=largest){
       IUtil.swap(a, index, largest);
       recoverHeap(a,heapSize,largest);
    }
}
public static void main(String[] args) {
    int[] a=IUtil.getRandom(10, 100, 10);
    heapSort(a);
    for (int i = 0; i < a.length; i++) {
        System.out.print(a[i]+" ");
    }
}
}
