package Java8NewFeature.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: lick
 * @Description:
 * @Date:2018/10/23 23:20
 */
public class TestStream {
    private List produceStudent(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("小李", 11));
        list.add(new Person("小张", 10));
        list.add(new Person("小杨", 9));
        return list;
    }

    public static void main(String[] args) {
        List<Person> list = new TestStream().produceStudent();
        //filter过滤方法
        List<Person> list1 = list.stream().filter(person -> person.getName().equals("小杨")).collect(Collectors.toList());
        for (Person person: list1
             ) {
            System.out.println(person.toString());
        }
        //map，过滤出指定的值
        List<String> list2 = list.stream().filter(person -> person.getName().equals("小杨")).map(Person::getName).collect(Collectors.toList());
        for (String person: list2
                ) {
            System.out.println(person);
        }

        Map map = new HashMap<>();
        map.put(1,"桃子");
        map.put(2, "栗子");
        map.put(3, "柿子");

            //对map类型操作
        Map map1 = map.entrySet().stream()
                .filter((e) -> e.getValue() == "桃子")
                .collect(Collectors.toMap(
                        (e) -> (String) e.getKey(),
                        (e) -> e.getValue()
                ));
    }
    }
}
