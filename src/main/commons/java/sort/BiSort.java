package sort;

public class BiSort {
public int biSort(int[] a,int x){
    int low = 0,high = a.length-1;
    int mid;
  
        
    while(low<high){
    mid=(low+high)/2;
    if(x==a[mid]){
        return mid;
    }else if(x<a[mid]){
        high=mid-1;
        continue;
    }else{
        low=mid+1;
        continue;
    }
    
    }
    return -2;
    
}
}
