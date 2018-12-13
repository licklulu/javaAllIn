package cloneForMe;

import entity.Person;

/**
 * @Auther: licklulu
 * @Description:
 * @Date: 2018/10/23 10:38
 */
public class CloneSimpleTest implements Cloneable{
    public static void main(String[] args) {
        Person person = Person.getPerson("卢亮", 22, false, 1);
    }
}
