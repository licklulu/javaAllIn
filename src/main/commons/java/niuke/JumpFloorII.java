package niuke;

public class JumpFloorII {
public static int jumpFloorII(int target) {
    if(target<=2){
        return target;
    }else{
        return jumpFloorII(target-1)*2;
    }
        
    }
    public static void main(String[] args){
     jumpFloorII(10);
    }
}
