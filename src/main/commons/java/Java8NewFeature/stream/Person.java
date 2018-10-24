package Java8NewFeature.stream;

/**
 * @Auther: lick
 * @Description:
 * @Date:2018/10/23 23:18
 */
public class Person {
    public Person(String name, Integer age){
        this.age = age;
        this.name = name;
    }
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
