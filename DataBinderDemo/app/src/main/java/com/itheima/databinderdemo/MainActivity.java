package com.itheima.databinderdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.itheima.databinderdemo.sample.BasicActivity;
import com.itheima.databinderdemo.sample.ObServableActivity;
import com.itheima.databinderdemo.sample.RecyclerViewActivity;
import com.itheima.databinderdemo.sample.ResourceActivity;

public class MainActivity extends Activity implements View.OnClickListener{
    private Intent intent;
    private Button btMainactBasic;
    private Button btMainactResource;
    private Button btMainactObservable;
    private Button btMainactRecycler;

    private void assignViews() {
        btMainactBasic = (Button) findViewById(R.id.bt_mainact_basic);
        btMainactResource = (Button) findViewById(R.id.bt_mainact_resource);
        btMainactObservable = (Button) findViewById(R.id.bt_mainact_observable);
        btMainactRecycler = (Button) findViewById(R.id.bt_mainact_recyclerview);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
        btMainactBasic.setOnClickListener(this);
        btMainactResource.setOnClickListener(this);
        btMainactObservable.setOnClickListener(this);
        btMainactRecycler.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_mainact_basic:
                intent = new Intent(MainActivity.this,BasicActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_mainact_resource:
                intent = new Intent(MainActivity.this,ResourceActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_mainact_observable:
                intent = new Intent(MainActivity.this,ObServableActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_mainact_recyclerview:
                intent = new Intent(MainActivity.this,RecyclerViewActivity.class);
                startActivity(intent);
                break;
        }
    }
}
