package com.itheima.databinderdemo.sample;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.itheima.databinderdemo.R;
import com.itheima.databinderdemo.databinding.ActivityBasicBinding;
import com.itheima.databinderdemo.model.Student;
import com.itheima.databinderdemo.model.Teacher;


/**
 * Created by jie on 2016/3/29.
 */
public class BasicActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBasicBinding binding = DataBindingUtil.setContentView(
                this, R.layout.activity_basic);//这是个View对象
        Student student = new Student("du", 16);//这是个model
//        findViewById(R.id.tv).setText("du");
        binding.setStu(student);
        Teacher teacher = new Teacher("jie", true);
        binding.setTea(teacher);
    }
}
