package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class countThread {
    static  int count =0;
public static  void count(){
    
    try {
        Thread.sleep(10);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    count++;
}
public static void main(String[]  args) {
    Lock lock=new ReentrantLock();
    for (int i = 0; i < 1000; i++) {
        new Thread(new Runnable(){
            
                @Override
                public  void run() {
                   lock.lock();
                       countThread.count(); 
                       
                       
                        System.out.println(countThread.count);
                        lock.unlock();
                }
//            new Thread(()->{lock.lock(); countThread.count(); System.out.println(countThread.count);lock.unlock();}).start();
           
           
        }).start();
        
    }
//    try {
//        Thread.sleep(20000);
//        System.out.println(countThread.count);
//    } catch (InterruptedException e) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//    }
// 
}
}
