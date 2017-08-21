package compare;

public class ComparableImpl implements Comparable<Student>{
private String name;
private int age;
    @Override
    public int compareTo(Student o) {
        
        Student s=new Student(name,age);
        int res=0;
        Student stu=(Student)o;
        if(s.getAge()>o.getAge()){
            res=1;
        }else if(s.getAge()<o.getAge()){
            res=-1;
        }else{
            res=0;
        }
        return res;
    }

}
