package Advanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student(12,5, "홍길동");
        Student s2 = new Student(17,6, "가나다");
        Student s3 = new Student(3,4, "라마바");
        Student s4 = new Student(1,4, "사아자");

        List<Student> al = new ArrayList<>();

        al.add(s1);
        al.add(s2);
        al.add(s3);
        al.add(s4);
        Collections.sort(al);
        System.out.println(al);

    }
}
