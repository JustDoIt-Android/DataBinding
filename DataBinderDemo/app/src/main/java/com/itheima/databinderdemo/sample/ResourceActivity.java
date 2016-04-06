package com.itheima.databinderdemo.sample;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.itheima.databinderdemo.R;
import com.itheima.databinderdemo.databinding.ResourceBinding;

/**
 * Created by jie on 2016/4/1.
 */
public class ResourceActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ResourceBinding resourceBinding = DataBindingUtil.setContentView(this, R.layout.activity_resource);

        resourceBinding.setType(true);
    }
}
