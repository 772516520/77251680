package com.i77251680.core.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class T511 {
    public static Writer writeT511() throws IOException {
        Set<String> domains = new HashSet<>();
        domains.add("aq.qq.com");
        domains.add("buluo.qq.com");
        domains.add("connect.qq.com");
        domains.add("docs.qq.com");
        domains.add("game.qq.com");
        domains.add("gamecenter.qq.com");
//      domains.add("graph.qq.com");
        domains.add("haoma.qq.com");
        domains.add("id.qq.com");
//      domains.add("imgcache.qq.com");
        domains.add("kg.qq.com");
        domains.add("mail.qq.com");
        domains.add("mma.qq.com");
        domains.add("office.qq.com");
//      domains.add("om.qq.com");
        domains.add("openmobile.qq.com");
        domains.add("qqweb.qq.com");
        domains.add("qun.qq.com");
        domains.add("qzone.qq.com");
        domains.add("ti.qq.com");
        domains.add("tenpay.com");
        domains.add("v.qq.com");
        domains.add("vip.qq.com");
        domains.add("y.qq.com");
        Writer stream = new Writer()
                .writeShort(domains.size());
        for (String v : domains) {
            stream.writeByte(0x01).writeTlv(v);
        }
        return stream;
    }
}
