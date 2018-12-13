package aes;

import java.util.Random;

/**
 * @Auther: lick
 * @Description:
 * @Date:2018/12/13 19:30
 */
public class Long2Hour {
    public static void main(String[] args) {
        Long totalMilliSeconds = System.currentTimeMillis();
//        Long totalMilliSeconds = 1644698752000L;
        long totalSeconds = totalMilliSeconds / 1000;
        long currentSecond = totalSeconds % 60;
        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;
        System.out.println(totalMilliSeconds);
        long currentHour = totalMilliSeconds - currentMinute*60*1000 -currentSecond*1000;
//        System.out.println(currentMinute + ":" + currentSecond);
        Long current = currentHour/1000*1000;//current需要加上9999
        System.out.println(currentHour/1000*1000);
        Random random = new Random();
        random.setSeed(current + 9999);
        for(int i = 0; i < 10; i++){
            Math.abs(random.nextInt());
            if(i == 7){
                System.out.println(Math.abs(random.nextInt()));
            }
        }
//        System.out.println(Math.abs(random.nextInt()));
    }
}
