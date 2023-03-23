package com.i77251680.event.events;

public class InternalVerify {
    public String url;
    public String phone;

    private InternalVerify(String url, String phone) {
        this.url = url;
        this.phone = phone;
    }

    public static InternalVerify set(String url, String phone) {
        return new InternalVerify(url, phone);
    }
}
