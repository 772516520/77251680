package com.i77251680.entity.enums;

/**
 * 在线状态
 */
public enum OnlineStatus {
    Online(11, "在线"), Absent(31, "离开"), Invisible(41, "隐身"), Busy(50, "忙碌"), Qme(60, "Qme"), DontDisturb(70, "请勿打扰");
    private final int status;
    private final String remark;

    OnlineStatus(int status, String remark) {
        this.status = status;
        this.remark = remark;
    }

    public int getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return this.remark;
    }
}
