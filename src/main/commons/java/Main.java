import java.util.Stack;

public class Main {
    public static  void print(int n,String source,String target,String helper) {
if(n==1){
    System.out.println(n+" from "+source+" to "+target);
    return;
}
print(n-1,source,helper,target);

System.out.println(n+" from "+source+" to "+target);
print(n-1,helper,source,target);
}
    public static void main(String[] args) {
        Long str = Long.parseLong("3600000L");
        System.out.println();
    }
}
