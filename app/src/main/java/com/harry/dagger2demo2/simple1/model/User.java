package com.harry.dagger2demo2.simple1.model;

/**
 * 用户实体类
 * Created by ybxiang on 2017-12-11.
 */
public class User {
    private String userName = "harry";
    private String imgUrl = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=838427587," +
            "597146901&fm=27&gp=0.jpg";

    public User() {

    }

    public User(String userName, String imgUrl) {
        this.userName = userName;
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
