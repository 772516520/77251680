package com.i77251680.core.client;

import com.i77251680.constants.Constants;
import com.i77251680.utils.Utils;

import static io.netty.buffer.Unpooled.wrappedBuffer;

public class Sig {
    public static byte[] d2 = Constants.BUF0;
    public static byte[] d2key = Constants.BUF0;
    public static byte[] skey = Constants.BUF0;
    public static byte[] tgt = Constants.BUF0;
    public static byte[] t104 = Constants.BUF0;
    public static byte[] t174 = Constants.BUF0;
    public static byte[] t402 = Constants.BUF0;
    public static byte[] t403 = Constants.BUF0;
    public static byte[] G = Constants.BUF0;
    public static byte[] qrsig = Constants.BUF0;
    public static byte[] publicKey = Constants.BUF0;
    public static byte[] shareKey = Constants.BUF0;
    public static byte[] tgtgt = Utils.randomBytes(16);
    public static byte[] randkey = Utils.randomBytes(16);
    public static byte[] session = Utils.randomBytes(4);
    public static int seq = wrappedBuffer(Utils.randomBytes()).readInt() & 0xfff;

}
