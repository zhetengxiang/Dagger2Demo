package com.harry.dagger2demo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.harry.dagger2demo2.simple1.component.DaggerMainComponent;
import com.harry.dagger2demo2.simple1.model.User;
import com.harry.dagger2demo2.simple1.module.MainModule;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "singleton";
    @Inject
    User mUser;
    @Inject
    User mUser2;

    @Named("ox")
    @Inject
    User mOXUser;

    @Named("bird")
    @Inject
    User mBirdUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerMainComponent.builder().mainModule(new MainModule("lilei", "lileiAvatar")).build().inject(this);
        Log.d(TAG, "mUser = " + mUser);
        Log.d(TAG, "mUser2 = " + mUser2);
//        Log.d(TAG, "mOXUser = " + mOXUser);
//        Log.d(TAG, "mBirdUser = " + mBirdUser);
    }

    public void onToSecond(View view) {
        Log.d(TAG, "click me。。。。");
        startActivity(new Intent(MainActivity.this,SecondActivity.class));
    }
}
