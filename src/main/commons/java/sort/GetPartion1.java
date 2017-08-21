package sort;

public class GetPartion1 {
public int getPartion1(int[] array,int begin,int end){
    int pos=begin;
    int pivot=array[begin];
    for (int i = begin+1; i<array.length; i++) {
        if(array[i]<=pivot){
            pos++;
            if(i!=pos){
                int temp=array[i];
                array[i]=array[pos];
                array[pos]=temp;
            }
        }
    }
    int temp1=array[begin];
    array[begin]=array[pos];
    array[pos]=temp1;
    return pos;
    
}
}
