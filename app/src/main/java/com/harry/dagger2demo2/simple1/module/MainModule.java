package com.harry.dagger2demo2.simple1.module;

import com.harry.dagger2demo2.simple1.model.User;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Module类，内容提供者
 * Created by ybxiang on 2017-12-11.
 */
@Module
public class MainModule {
    private String userName;
    private String imgUrl;

    public MainModule(String userName, String imgUrl) {
        this.userName = userName;
        this.imgUrl = imgUrl;
    }

    @Singleton
    @Provides
    public User provideUser() {
        return new User(userName, imgUrl);
    }

    /**
     * 大牛
     */
    @Named("ox")
    @Provides
    public User provideOX() {
        return new User("OX", "OX Avatar");
    }

    /**
     * 小菜鸟
     */
    @Named("bird")
    @Provides
    public User provideBird() {
        return new User("Bird", "Bird Avatar");
    }
}
