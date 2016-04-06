package com.itheima.databinderdemo.model;

/**
 * Created by jie on 2016/3/29.
 */
public class Student {
    public Student(String studentName, int age) {
        this.studentName = studentName;
        this.age = age;
    }

    public String studentName;
    public int age;
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
