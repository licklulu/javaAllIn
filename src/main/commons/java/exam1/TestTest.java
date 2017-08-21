package exam1;

import java.util.Scanner;

public class TestTest {
    public char find(){
    Scanner input=new Scanner(System.in);
    for (int i = 0; i < 10; i++) {
        int p=input.nextInt();
        if(p<60||p>100){
            System.out.println();
            return '1';
        }
    }
    int p = 0;
    
    return 0;
    }
    
}
