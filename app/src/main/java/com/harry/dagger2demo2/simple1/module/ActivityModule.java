package com.harry.dagger2demo2.simple1.module;

import com.harry.dagger2demo2.simple1.model.Presenter;

import dagger.Module;
import dagger.Provides;

/**
 * Module类，内容提供者
 * Created by ybxiang on 2017-12-11.
 */
@Module
public class ActivityModule {
    @Provides
    public Presenter providePresenter(){
        return new Presenter();
    }
}
