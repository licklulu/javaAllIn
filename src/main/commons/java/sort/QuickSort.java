package sort;

public class QuickSort {
public int[] quickSort(int[] array,int begin,int end){
//   GetPartion gp=new GetPartion();
//    int m=gp.getPartion(array, begin, end);
    GetPartion1 gp=new GetPartion1();
    int m=gp.getPartion1(array, begin, end);
    if(m>begin){
    quickSort(array,begin,m-1);
    }
    if(m<end){
    quickSort(array,m+1,end);
    }
    return array;
}
}
