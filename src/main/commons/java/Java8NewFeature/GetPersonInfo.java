package Java8NewFeature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import entity.Person;

public class GetPersonInfo {
private static List<Person> persons=Arrays.asList(new Person[]{
        new Person("黄一",23,true,5000),
        new Person("余一",30,false,8000),
        new Person("黄二",28,true,7000),
        new Person("李宇",25,true,6000),
        new Person("黄三",32,false,9000),
        new Person("黄四",23,true,7000),
        new Person("余玉",29,false,6000),
        new Person("黄六",27,true,5000),
        new Person("黄琪",23,false,5000),
        new Person("黄六",27,true,5000),
        new Person("黄三",27,false,5000)
});
public List<Person> getPerson(InfoPerson infoPerson){
    
    List<Person> results=new ArrayList<Person>();
    for (Person person : persons) {
            if(infoPerson.getInfo(person)){
                results.add(person);
            }
        
    }
    
    return results;
}
public static void main(String[] args) {
    GetPersonInfo gpi=new GetPersonInfo();
//   List<Person> result= gpi.getPerson(new InfoPerson() {
//      List<Person> result= gpi.getPerson(new InfoPerson() {
//    
//    @Override
//    public boolean getInfo(Person person) {
//        
//        return person.getSalary()>6000&&person.getAge()<30;
//    }
//});
    //不加{}表示接口函数返回值    ...
    //加{}表示接口函数中的代码语句  return...
       List<Person> result=gpi.getPerson((Person person)->
       person.getSalary()>6000);
       //Comparator 为函数式接口，用lambda表达式调用Comparator
//  Collections.sort(result,(Person p1,Person p2)->{return p1.getSalary()-p2.getSalary();});
   //Collections.sort(result,Comparator.comparing((Person p)->p.getSalary()));
   Collections.sort(result,Comparator.comparing(Person::getSalary));
//       for (Person person : result) {
//    System.out.println(person);
//}
   //lambda ：：操作符使用
//   GetRandom random=Math::random;
       
       
       //流
   Stream<Person> stream=persons.stream();
   //流过滤
   //函数式编程，目前只能处理简单的
   List<Person> plist=stream.filter((Person p)->!p.isFamousUniversity()).collect(Collectors.toList());
// plist.stream().forEach((Person p)-> {System.out.println(p);});

 //排序
//  persons.stream().sorted((Person p1,Person p2)-> p1.getAge()-p2.getAge()).forEach((Person p)->System.out.println(p));
 persons.stream().forEach((Person p)->{System.out.println(p);});
 System.out.println("--------------------");
////截取limit
// persons.stream().limit(3).forEach((Person p)->{System.out.println(p);});
// //跳过skip
// persons.stream().skip(3).forEachOrdered(System.out::println);
// //映射map
// persons.stream().map((Person p)->p.getName()).forEach(System.out::println);
// persons.stream().map(Person::getName).forEach(System.out::println);
 //合并流 flatMap
// List<String> list=new ArrayList<String>();
// list.add("abc www");
// list.add("java nihao");
// list.add("me good");
//
// list.stream().map((String s)->s.split(" ")).flatMap(Arrays::stream).forEach(System.out::println);
 //规约reduce，客用来求最大或者最小
// Person p=persons.stream().reduce((Person p1,Person p2)->p1.getSalary()>p2.getSalary()?p1:p2).get();
// System.out.println(p);
 //mapToDouble,mapToInt用来求和，平均数
// double d=persons.stream().mapToDouble(Person::getAge).average().getAsDouble();
// System.out.println(d);
 //也可以用collect来求平均值,求和
 Double b=persons.stream().collect(Collectors.averagingDouble(Person::getAge));
 System.out.println(b);
 //分组groupingBy,里边可以按照多种情况分组
// Map<Integer, List<Person>> map=persons.stream().collect(Collectors.groupingBy(Person::getSalary));
// System.out.println(map);
// System.out.println("-----------");
//System.out.println(persons.stream().collect(Collectors.groupingBy(Person::getSalary,Collectors.groupingBy(Person::getAge))));
  }


}
//class InfoPersonImpl implements InfoPerson{
//
//    @Override
//    public boolean getInfo(Person person) {
//        return person.getSalary()>6000;
//    }
//    
//}
interface GetRandom{
    double getRandom();
}
interface InfoPerson{
    public boolean getInfo(Person person);
}