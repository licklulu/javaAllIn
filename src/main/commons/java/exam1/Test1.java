package exam1;

public class Test1 {
public int test1(int[] a){
    for (int i = 0; i < a.length; i++) {
        if(a[i]>a[i+1]){
            
            return a[i+1];
         
        }
    }
    return 0;
}
public int test11(int[] a,int low,int high){
    int mid=(low+high)/2;
    for(int i=mid;i<high;i++){
        if(a[i]>a[i+1]){
            return a[i+1];
        }
    }
    return 0;
    
}
}
