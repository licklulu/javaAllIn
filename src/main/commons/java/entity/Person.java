package entity;



public class Person  {
private String name;
private int age;
private boolean isFamousUniversity;
private int salary;
public Person(String name, int age, boolean isFamousUniversity, int salary) {
    super();
    this.name = name;
    this.age = age;
    this.isFamousUniversity = isFamousUniversity;
    this.salary = salary;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public int getAge() {
    return age;
}
public void setAge(int age) {
    this.age = age;
}
public boolean isFamousUniversity() {
    return isFamousUniversity;
}
public void setFamousUniversity(boolean isFamousUniversity) {
    this.isFamousUniversity = isFamousUniversity;
}
public int getSalary() {
    return salary;
}
public void setSalary(int salary) {
    this.salary = salary;
}
@Override
public String toString() {
    return "Person [name=" + name + ", age=" + age + ", isFamousUniversity=" + isFamousUniversity + ", salary=" + salary
            + "]";
}
//@Override
//public int compareTo(Person o) {
//    Person s=new Person(name,age,isFamousUniversity,salary);
//    int res=0;
//    Person stu=(Person)o;
//    if(s.getAge()<o.getAge()){
//        res=1;
//    }else if(s.getAge()>o.getAge()){
//        res=-1;
//    }else{
//        res=0;
//    }
//    return res;
//}

}
