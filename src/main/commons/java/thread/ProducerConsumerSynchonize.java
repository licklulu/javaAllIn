package thread;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerSynchonize {
   static List<Integer> hotDoger=new ArrayList<>();
public static void main(String[] args) {
    for (int i = 1; i < 4; i++) {
        new Thread(new producer(i)).start();
    }
   for (int i = 1; i < 5; i++) {
    new Thread(new Consumer(i)).start();
}
   try {
    Thread.sleep(100000);
} catch (InterruptedException e) {
    e.printStackTrace();
}
}
private static class producer implements Runnable{
    int i=1;
    int pid=1;
    public producer(int pid){
        this.pid=pid;
    }
    @Override
    public void run() {
       while(true){
           try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
           synchronized (hotDoger) {
            
       
           if(hotDoger.size()<10){
              hotDoger.add(pid*10000+1);
               System.out.println("第"+this.pid+"号厨师"+"正在生产"+this.pid+"000"+i+"号热狗");
               i++;
               hotDoger.notifyAll();
           }else{
               try {
                hotDoger.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           }
       }
       }
    }
    
}
private static class Consumer implements Runnable{
    
    int cid=1;
    public Consumer(int cid){
        this.cid=cid;
    }
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (hotDoger) {
                
           
            if(hotDoger.size()>0){
                
               System.out.println("第"+cid+"号消费者正在小费:"+hotDoger.remove(0));
               
               hotDoger.notifyAll();
            }else{
                try {
                    hotDoger.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            }
        }
    }
    
}
}
