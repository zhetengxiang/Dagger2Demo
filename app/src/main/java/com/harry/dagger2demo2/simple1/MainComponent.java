package com.harry.dagger2demo2.simple1;

import com.harry.dagger2demo2.MainActivity;

import dagger.Component;

/**
 * 连接器
 * 1. 声明都是接口
 * Created by ybxiang on 2017-12-11.
 */
@Component
public interface MainComponent {
    void inject(MainActivity activity);
}
