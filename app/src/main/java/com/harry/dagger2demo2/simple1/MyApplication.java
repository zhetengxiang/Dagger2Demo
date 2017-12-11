package com.harry.dagger2demo2.simple1;

import android.app.Application;

import com.harry.dagger2demo2.simple1.component.AppComponent;
import com.harry.dagger2demo2.simple1.component.DaggerAppComponent;
import com.harry.dagger2demo2.simple1.module.AppModule;

/**
 * 自定义Application
 * Created by ybxiang on 2017-12-11.
 */
public class MyApplication extends Application {
    private static MyApplication mApplication = null;
    private AppComponent mAppComponent;

    public static MyApplication getInstance() {
        return mApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule("lilei","lilei avatart")).build();
        mAppComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
