package com.i77251680.network.protocol.packet.unpack.login;

public class T119 {
    private final int age;
    private final int gender;
    private final String nickname;

    public T119(int age, int gender, String nickname) {
        this.age = age;
        this.gender = gender;
        this.nickname = nickname;
    }

    public static T119 set(int age, int gender, String nickname) {
        return new T119(age, gender, nickname);
    }

    public int getAge() {
        return age;
    }

    public int getGender() {
        return gender;
    }

    public String getNickname() {
        return nickname;
    }
}
