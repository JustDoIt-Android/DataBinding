package com.itheima.databinderdemo.sample;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.itheima.databinderdemo.R;
import com.itheima.databinderdemo.databinding.ActivityObservableBinding;
import com.itheima.databinderdemo.model.ObservableUser;

/**
 * Created by jie on 2016/4/1.
 */
public class ObServableActivity extends Activity {

    private ActivityObservableBinding observableBinding;
    private ObservableUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        observableBinding = DataBindingUtil.setContentView(this, R.layout.activity_observable);

        user = new ObservableUser("LiuPeng","Very");
        observableBinding.setUser(user);

    }

    public void clickToIDText(View view) {
        observableBinding.tvObservableId.setText("换个Text");
    }

    public void clickToChange(View view){
//        user是一个对象Bean，是个model,不是textview
        user.setName("LiuPeng1");
        user.setBeautiful("NO");
    }

}
