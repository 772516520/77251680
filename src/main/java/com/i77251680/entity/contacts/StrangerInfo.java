package com.i77251680.entity.contacts;

public class StrangerInfo {
    public long user_id;
    public String nickname;

    protected StrangerInfo() {
    }

    private StrangerInfo(long user_id, String nickname) {
        this.user_id = user_id;
        this.nickname = nickname;
    }

    public void set(long user_id, String nickname) {
        new StrangerInfo(user_id, nickname);
    }

    public long getUser_id() {
        return user_id;
    }

    public String getNickname() {
        return nickname;
    }
}
