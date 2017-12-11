package com.harry.dagger2demo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.harry.dagger2demo2.simple1.MyApplication;
import com.harry.dagger2demo2.simple1.model.User;

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
        MyApplication.getInstance().getAppComponent().getActivityComponent().inject(this);
//        DaggerActivityComponent.builder().activityModule(new ActivityModule()).appComponent(MyApplication
//                .getInstance().getAppComponent()).build().inject(this);
        Log.d(TAG, "mUser = " + mUser);
        Log.d(TAG, "mUser2 = " + mUser2);

        Log.d(TAG, "mOXUser = " + mOXUser);
        Log.d(TAG, "mBirdUser = " + mBirdUser);
    }

    public void onToSecond(View view) {
        Log.d(TAG, "click me。。。。");
        startActivity(new Intent(MainActivity.this, SecondActivity.class));
    }
}
