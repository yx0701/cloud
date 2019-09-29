package com.yx.auth.testpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student {
    private int age;

    public Student(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Student s1 = new Student(1);
        Student s2 = new Student(2);
        Student s3 = new Student(3);
        Student s4 = new Student(4);
        Student s5 = new Student(5);
        List<Student> list = new ArrayList<Student>();
        list.add(s2);
        list.add(s5);
        list.add(s1);
        list.add(s3);
        list.add(s4);
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.age>o2.age)
                    return -1;
                return 1;
            }
        });
        System.out.println();
    }
}
