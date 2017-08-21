package util;

public  class IUtil {
    public static void swap(int[] array,int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
public static int[] getRandom(int length,int max,int min){
    int[] array=new int[length];
    for (int i = 0; i < array.length; i++) {
        array[i]=(int)(Math.random()*(max-min+1)+min);
    }
    return array;
}
public static int[] getNotRepetationRandom(int  length,int max,int min){
    int[] array=new int[length];
    int i=0;
    while(i<length){
        int temp=(int)(Math.random()*(max-min+1)+min);
        if(indexOf(array,temp)==-1){
            array[i]=temp;
            i++;
        }
    }
        
    
    return array;
    
}
private static int indexOf(int[] array, int temp) {
    for (int i = 0; i < array.length; i++) {
        if(array[i]==temp){
            return i;
        }
    }
    return -1;
}
public static int getDigit(int src,int d){
    int digit=src/((int)(Math.pow(10,d-1)))%10;
    return digit;
    
}
}
