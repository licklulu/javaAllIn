package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
//private static Object lock1=new Object();
//private static Object lock2=new Object();
   static Lock lock1=new ReentrantLock();
   static Lock lock2=new ReentrantLock();
private static class shareThread1 implements Runnable{

    @Override
    public void run() {
        synchronized (lock1) {
            try {
                Thread.sleep(50);
                synchronized (lock2) {
                    System.out.println("shareThread1");   
                   }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
    
}
private static class shareThread2 implements Runnable{

    @Override
    public void run() {
        synchronized (lock2) {   
           if(lock1.tryLock()){
              
                System.out.println("shareThread2");
              
            }
           }
        }
        
    }
    

public static void main(String[] args) {
    new Thread(new shareThread1()).start();
    new Thread(new shareThread2()).start();
}
}
