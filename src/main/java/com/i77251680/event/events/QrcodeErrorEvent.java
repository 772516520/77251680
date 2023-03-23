package com.i77251680.event.events;

public class QrcodeErrorEvent {
    public int retcode;
    public String msg;

    private QrcodeErrorEvent(int retcode, String msg) {
        this.retcode = retcode;
        this.msg = msg;
    }

    public static QrcodeErrorEvent set(int retcode, String msg) {
        return new QrcodeErrorEvent(retcode, msg);
    }
}
