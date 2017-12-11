package com.harry.dagger2demo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.harry.dagger2demo2.simple1.MyApplication;
import com.harry.dagger2demo2.simple1.component.DaggerActivityComponent;
import com.harry.dagger2demo2.simple1.model.User;
import com.harry.dagger2demo2.simple1.module.ActivityModule;

import javax.inject.Inject;

/**
 * 第二个界面
 */
public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "singleton";

    @Inject
    User mUser;

    @Inject
    User mUser2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        DaggerActivityComponent.builder().activityModule(new ActivityModule()).appComponent(MyApplication
                .getInstance().getAppComponent()).build().inject(this);

        Log.d(TAG, "mUser = " + mUser);
        Log.d(TAG, "mUser2 = " + mUser2);
    }
}
