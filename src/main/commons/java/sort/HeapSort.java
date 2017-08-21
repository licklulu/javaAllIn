package sort;

import util.Util;

public class HeapSort {
    public void heapSort(int[] array){
        buidHeap(array);
        for (int i = array.length-1; i >=0; i--) {
            Util.swap(array, 0, i);
            maxHeap(array,i,0);
        }
    }
    public void buidHeap(int[] array){
    if(array==null||array.length<1)
        return;
    int half=array.length/2;
    for (int i=half; i >=0 ;i--) {
        maxHeap(array,array.length,i);
    }
}
public void maxHeap(int[] array,int heapSize,int index){
    int left=2*index+1;
    int right=2*index+2;
    int largest=index;
    if(left<heapSize&&array[left]>array[largest]){
        largest=left;
    }
    if(right<heapSize&&array[right]>array[largest]){
        largest=right;
    }
    if(index!=largest){
        Util.swap(array, index, largest);
        maxHeap(array,heapSize,largest);
    }
}
}
