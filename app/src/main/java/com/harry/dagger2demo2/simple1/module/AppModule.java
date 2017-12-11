package com.harry.dagger2demo2.simple1.module;

import com.harry.dagger2demo2.simple1.model.User;
import com.harry.dagger2demo2.simple1.scope.AppScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Module类，内容提供者
 * Created by ybxiang on 2017-12-11.
 */
@Module
public class AppModule {
    private String userName;
    private String imgUrl;

    public AppModule(String userName, String imgUrl) {
        this.userName = userName;
        this.imgUrl = imgUrl;
    }

    @AppScope
    @Provides
    public User provideUser() {
        return new User(userName, imgUrl);
    }
    /**
     * 大牛
     */
    @Named("ox")
    @AppScope
    @Provides
    public User provideOX() {
        return new User("OX", "OX Avatar");
    }

    /**
     * 小菜鸟
     */
    @Named("bird")
    @AppScope
    @Provides
    public User provideBird() {
        return new User("Bird", "Bird Avatar");
    }
}
