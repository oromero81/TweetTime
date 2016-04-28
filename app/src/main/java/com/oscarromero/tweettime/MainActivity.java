package com.oscarromero.tweettime;

import android.os.Bundle;

import com.oscarromero.tweettime.di.MainModule;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new MainModule());
    }
}