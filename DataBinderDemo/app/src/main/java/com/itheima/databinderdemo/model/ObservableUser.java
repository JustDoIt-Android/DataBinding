package com.itheima.databinderdemo.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.itheima.databinderdemo.BR;

/**
 * Created by jie on 2016/4/1.
 */
public class ObservableUser extends BaseObservable {
    private String Name;
    private String Beautiful;

    public ObservableUser(String name, String beautiful) {
        Name = name;
        Beautiful = beautiful;
    }

    @Bindable
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getBeautiful() {
        return Beautiful;
    }

    public void setBeautiful(String beautiful) {
        Beautiful = beautiful;
        notifyPropertyChanged(BR.beautiful);
    }
}
