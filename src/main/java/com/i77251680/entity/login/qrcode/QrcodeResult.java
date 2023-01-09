package com.i77251680.entity.login.qrcode;

public class QrcodeResult {
    public int retcode;
    public long uin;
    public byte[] t106;
    public byte[] t16a;
    public byte[] t318;
    public byte[] tgtgt;

    public QrcodeResult(int retcode,
                        long uin,
                        byte[] t106,
                        byte[] t16a,
                        byte[] t318,
                        byte[] tgtgt) {
        this.retcode = retcode;
        this.uin = uin;
        this.t106 = t106;
        this.t16a = t16a;
        this.t318 = t318;
        this.tgtgt = tgtgt;
    }
}
