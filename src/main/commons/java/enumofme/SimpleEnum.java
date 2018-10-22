package enumofme;

/**
 * @Auther: lick
 * @Description:
 * @Date: 2018/10/19 9:55
 */
public class  SimpleEnum {
    enum DAY{
        MONDAY, TUESDAY, WEDNESDAY,
        THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
    public static Integer getDayCode(DAY day){
        return day.ordinal()+1000;
    }
    public static void main(String[] args) {
        //1.枚举数组
        DAY[] days = new DAY[]{DAY.MONDAY, DAY.TUESDAY, DAY.WEDNESDAY, DAY.THURSDAY, DAY.FRIDAY, DAY.SATURDAY, DAY.SUNDAY};
        //2.遍历枚举
        for (DAY day : DAY.values()){
            System.out.println(day.ordinal()+1000);
        }
        //3.仿照错误code返回
        System.out.println(getDayCode(DAY.FRIDAY));
        //4.values
        DAY[] days2 = DAY.values();
        for (int i = 0; i < days2.length; i++){
            System.out.println(days2[i]);//输出MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY
        }
//        5.valueof
        System.out.println(DAY.valueOf("MONDAY"));//输出MONDAY

    }
}
