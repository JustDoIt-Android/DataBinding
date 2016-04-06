package com.itheima.databinderdemo.model;

/**
 * Created by jie on 2016/3/31.
 */
public class Teacher {
    public String Name;
    public boolean isWork;

    public Teacher(String name, boolean isWork) {
        Name = name;
        this.isWork = isWork;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public boolean isWork() {
        return isWork;
    }

    public void setIsWork(boolean isWork) {
        this.isWork = isWork;
    }
}
