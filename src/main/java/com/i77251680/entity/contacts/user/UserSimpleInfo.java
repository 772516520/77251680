package com.i77251680.entity.contacts.user;

import com.i77251680.entity.enums.Gender;

public class UserSimpleInfo {
    public long user_id;
    public String nickname;
    public Gender gender;
    public int age;
    public String area;

    UserSimpleInfo(long user_id, String nickname, Gender gender, int age, String area) {
        this.user_id = user_id;
        this.nickname = nickname;
        this.gender = gender;
        this.age = age;
        this.area = area;
    }

    public static UserSimpleInfo set(long user_id, String nickname, Gender gender, int age, String area) {
        return new UserSimpleInfo(user_id, nickname, gender, age, area);
    }
}
