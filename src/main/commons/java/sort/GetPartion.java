package sort;

public class GetPartion {
public int getPartion(int[] array,int begin,int end){
    int key=array[begin];
    while(begin<end){
        
        /**
         * 从右向左查找，找到第一个小于key的值然后停下来，
         * 然后把key值与右边的值交换
         */
         while(array[end]>=key&&begin<end)
            end--;
            array[begin]=array[end];
       
        while(array[begin]<=key&&begin<end)
            begin++;
            array[end]=array[begin];
        
        
    }
   array[end]=key;
    return end;
}
}
