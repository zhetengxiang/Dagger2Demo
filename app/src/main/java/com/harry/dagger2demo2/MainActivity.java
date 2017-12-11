package com.harry.dagger2demo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.harry.dagger2demo2.simple1.component.DaggerMainComponent;
import com.harry.dagger2demo2.simple1.model.User;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Inject
    User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerMainComponent.create().inject(this);
        Log.d(TAG, "mUser = " + mUser);
    }
}
