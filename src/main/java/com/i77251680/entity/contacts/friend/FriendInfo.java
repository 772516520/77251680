package com.i77251680.entity.contacts.friend;

import com.i77251680.entity.contacts.StrangerInfo;
import com.i77251680.entity.enums.Gender;

public class FriendInfo extends StrangerInfo {
    private int class_id;
    private Gender gender;
    private String remark;
    private String nickname;

    private FriendInfo(int class_id, Gender gender, String remark, String nickname) {
        super();
        this.gender = gender;
        this.remark = remark;
        this.class_id = class_id;
        this.nickname = nickname;
    }

    public static FriendInfo set(int class_id, Gender gender, String remark, String nickname) {
        return new FriendInfo(class_id, gender, remark, nickname);
    }

    public Gender getGender() {
        return gender;
    }

    public String getRemark() {
        return remark;
    }

    public int getClass_id() {
        return class_id;
    }

    public String getNickname() {
        return nickname;
    }
}
