package com.i77251680.event.events;

public class LoginError {
    public int type;
    public String msg;

    private LoginError(int type, String msg) {
        this.type = type;
        this.msg = msg;
    }

    public static LoginError set(int type, String msg) {
        return new LoginError(type, msg);
    }
}
