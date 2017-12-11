package com.harry.dagger2demo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.harry.dagger2demo2.simple1.MyApplication;
import com.harry.dagger2demo2.simple1.model.Song;
import com.harry.dagger2demo2.simple1.model.User;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import dagger.Lazy;

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

    @Inject
    Lazy<Song> mLazySong;

    @Inject
    Provider<Song> mProviderSong;

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

        Log.d(TAG, "mLazySong = " + mLazySong.get());
        Log.d(TAG, "mLazySong1 = " + mLazySong.get());
        Log.d(TAG, "mLazySong2 = " + mLazySong.get());
        // 此时才创建mLazySong，以后每次调用get会得到同一个mLazySong对象

        Log.d(TAG, "mProviderSong = " + mProviderSong.get());
        Log.d(TAG, "mProviderSong1 = " + mProviderSong.get());
        Log.d(TAG, "mProviderSong2 = " + mProviderSong.get());
        // 此时才创建mProviderSong，以后每次调用get都会强制调用Module的Provides方法一次，根据Provides方法具体实现的不同，可能返回跟mProviderSong是同一个对象，也可能不是。
    }

    public void onToSecond(View view) {
        Log.d(TAG, "click me。。。。");
        startActivity(new Intent(MainActivity.this, SecondActivity.class));
    }
}
