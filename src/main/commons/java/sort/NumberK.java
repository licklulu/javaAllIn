package sort;

public class NumberK {
public int  numberK(int[] a,int k){
    
    for (int i = 0; i < a.length; i++) {
        int count=0;
        int v = 0;
        for (int j = 0; j < a.length; j++) {
            if(i!=j){
           v =a[i]-a[j];
           if(v>0){
               count++;
           }
            }
        }
        while((a.length-k)==(count++)){
            return a[i];
        }
    }
    return 0;
    
    
}
}
