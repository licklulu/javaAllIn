package recursion;

import util.IUtil;

public class GroupString {
/**
 * @param str
 * @param arr
 */
static void groupString(char[] strToChar,int i){
    char temp;
    if(strToChar==null||i>strToChar.length||i<0){
        return;
    }else if(i==strToChar.length){
        System.out.println(strToChar);
    }else{
        for(int j=i;j<strToChar.length;j++){
            temp=strToChar[j];
            strToChar[j]=strToChar[i];
            strToChar[i]=temp;
            groupString(strToChar, i+1);
            temp=strToChar[j];
            strToChar[j]=strToChar[i];
            strToChar[i]=temp;
        }
    }
    
}
public static void main(String[] args) {
    String str="abc";
   char[] strToChar=str.toCharArray();
   groupString(strToChar, 0);
}
}
