package com.i77251680.core.client;

import com.i77251680.constants.Constants;
import com.i77251680.crypto.ecdh.Ecdh;
import com.i77251680.utils.Random;

import static io.netty.buffer.Unpooled.wrappedBuffer;

public class Sig {
    public static byte[] d2 = Constants.BUF0;
    public static byte[] d2Key = Constants.BUF0;
    public static byte[] sKey = Constants.BUF0;
    public static byte[] tgt = Constants.BUF0;
    public static byte[] t104 = Constants.BUF0;
    public static byte[] t174 = Constants.BUF0;
    public static byte[] t402 = Constants.BUF0;
    public static byte[] t403 = Constants.BUF0;
    public static byte[] g = Constants.BUF0;
    public static byte[] qrsig = Constants.BUF0;
    public static long timeDiff;
    public static byte[] publicKey;
    public static byte[] shareKey;
    public static byte[] tgtgt = Random.randomBytes(16);
    public static byte[] randKey = Random.randomBytes(16);
    public static byte[] session = Random.randomBytes(4);
    public static int seq = wrappedBuffer(Random.randomBytes()).readInt() & 0xfff;

    static {
        Ecdh ecdh = new Ecdh();
        publicKey = ecdh.publicKey;
        shareKey = ecdh.shareKey;
    }

}
