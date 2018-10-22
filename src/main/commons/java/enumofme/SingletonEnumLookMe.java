package enumofme;

/**
 * @Auther: lick
 * @Description:
 * @Date: 2018/10/19 15:40
 */
public enum SingletonEnumLookMe {
    INSTANCE;

    private People peopleEnum;
    public People getPeopleEnum() {
        return peopleEnum;
    }
    public void setPeopleEnum(People peopleEnum) {
        this.peopleEnum = peopleEnum;
    }
    public static void main(String[] args) {
        System.out.println(SingletonEnumLookMe.INSTANCE.peopleEnum);//SingletonEnumLookMe.INSTANCE.peopleEnum为返回的实例
    }
}
