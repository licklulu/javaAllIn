package sort;

public class NumberKImprol {
    int m;
public int numerKImprol(int[] array,int begin,int end,int k){
    GetPartion gp=new GetPartion();
   m =gp.getPartion(array, begin, end);
    
    if(m==(array.length-k)){
        return array[m];
        
    }else if(((array.length-k)>m)&&((array.length-k)<end)){
        return numerKImprol(array,m+1,end,k);
        
    }else if(((array.length-k)>begin)&&((array.length-k)<m)){
       return numerKImprol(array,begin,m-1,k);
    }
    return 0;
    
}
}
