package com.i77251680.entity.enums;

public enum Gender {
    male(1, "male"), female(0, "female"), unknown(2, "unknown");
    private final int sex;
    private final String remark;

    Gender(int sex, String remark) {
        this.sex = sex;
        this.remark = remark;
    }

    public int getSex() {
        return this.sex;
    }

    public static Gender getSex(int sex) {
        if (sex == 1)
            return male;
        else if (sex == 2)
            return female;
        return unknown;
    }

    @Override
    public String toString() {
        return this.remark;
    }
}
