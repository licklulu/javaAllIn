package niuke;

public class JumpFloorII {
public int jumpFloorII(int target) {
    if(target<=2){
        return target;
    }else{
        return jumpFloorII(target-1)*2;
    }
        
    }
}
