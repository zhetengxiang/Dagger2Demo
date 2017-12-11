package com.harry.dagger2demo2.simple1.component;

import com.harry.dagger2demo2.MainActivity;
import com.harry.dagger2demo2.simple1.module.MainModule;

import dagger.Component;

/**
 * 连接器
 * 1. 声明都是接口
 * 2. 可以包含多個modules
 * Created by ybxiang on 2017-12-11.
 */
@Component(modules = {MainModule.class})
public interface MainComponent {
    void inject(MainActivity activity);
}
