package com.i77251680.entity.enums;

public enum LoginType {
    PASSWORD(1, "PasswordLogin"), SMS(3, "SMSLogin"), WE_CHAT(4, "微信一键登录");
    private final int type;
    private final String remark;

    LoginType(int type, String remark) {
        this.type = type;
        this.remark = remark;
    }

    public int getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return this.remark;
    }
}
