package compare;

public class Student implements Comparable<Student>{
    private String name;
    private int age;
    
    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
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
    @Override
    public int compareTo(Student o) {
        Student s=new Student(name,age);
        int res=0;
        Student stu=(Student)o;
        if(s.getAge()<o.getAge()){
            res=1;
        }else if(s.getAge()>o.getAge()){
            res=-1;
        }else{
            res=0;
        }
        return res;
    }
    
}