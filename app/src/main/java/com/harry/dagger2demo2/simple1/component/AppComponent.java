package com.harry.dagger2demo2.simple1.component;

import com.harry.dagger2demo2.simple1.MyApplication;
import com.harry.dagger2demo2.simple1.model.User;
import com.harry.dagger2demo2.simple1.module.AppModule;
import com.harry.dagger2demo2.simple1.scope.AppScope;

import javax.inject.Named;

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

    @Named("ox")
    User getOXUser(); // 提供ox
    @Named("bird")
    User getBirdUser(); // 提供bird
    User getUser(); // 提供user
    // 采用dependencies的方式会暴露所有被依赖方[AppModule]提供的对象，如果AppModule方法一多感觉不好维护呢
}
