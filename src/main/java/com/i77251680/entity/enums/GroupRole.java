package com.i77251680.entity.enums;

public enum GroupRole {
    owner(1, "owner"), admin(2, "admin"), member(0, "member");
    private int permissions;
    private String remark;

    GroupRole(int permissions, String remark) {
        this.permissions = permissions;
        this.remark = remark;
    }

    public int getPermissions() {
        return this.permissions;
    }

    @Override
    public String toString() {
        return this.remark;
    }
}
