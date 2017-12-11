package com.harry.dagger2demo2.simple1.component;

import com.harry.dagger2demo2.simple1.MyApplication;
import com.harry.dagger2demo2.simple1.module.AppModule;
import com.harry.dagger2demo2.simple1.scope.AppScope;

import dagger.Component;

/**
 * 连接器
 * 1. 声明都是接口
 * 2. 可以包含多個modules
 * Created by ybxiang on 2017-12-11.
 */
@AppScope
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MyApplication application);
}
