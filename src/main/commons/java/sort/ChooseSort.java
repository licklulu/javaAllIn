package sort;

public class ChooseSort {
    public int[] chooseSort(int[] array){
        int k,temp;
        for(int i=0;i<array.length;i++){
        k=i;
        for(int j=i;j<array.length;j++){
        if(array[k]>array[j]){
        k=j;
        }
        }
        temp=array[i];
        array[i]=array[k];
        array[k]=temp;
      
        }
        return array;
       
        }
}
