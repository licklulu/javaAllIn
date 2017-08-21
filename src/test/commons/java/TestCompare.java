

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import compare.Compar;
import compare.Student;

public class TestCompare {
    public static void main(String[] args) {
        List<Student> slist=new ArrayList<Student>();
       slist.add(new Student("黄达",21));
       slist.add(new Student("赵二",14));
       slist.add(new Student("王三",18));
       Collections.sort(slist);
       for (Student student : slist) {
        System.out.println(student.getName()+student.getAge());
    }
    }

   
}
