package com.i77251680.crypto.ecdh;

import com.i77251680.crypto.md5.Md5Crypto;
import com.i77251680.utils.HexFormat;

import javax.crypto.KeyAgreement;
import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;

public class Ecdh {
    private final String i77251680_PUBLIC_KEY = "04EBCA94D733E399B2DB96EACDD3F69A8BB0F74224E2B44E3357812211D2E62EFBC91BB553098E25E33A799ADC7F76FEB208DA7C6522CDB0719A305180CC54A82E";
    private final byte[] byteKey = HexFormat.of().parseHex(i77251680_PUBLIC_KEY);
    public final byte[] shareKey;

    public Ecdh() {
        this.shareKey = generateShareKey();
    }

    public byte[] generateShareKey() {
        try {
            PublicKey key = KeyFactory.getInstance("EC")
                    .generatePublic(new X509EncodedKeySpec(byteKey));
            KeyPairGenerator clientPair = KeyPairGenerator.getInstance("ECDH");
            clientPair.initialize(new ECGenParameterSpec("prime256v1"));
            KeyAgreement shareKeyAgree = KeyAgreement.getInstance("ECDH");
            shareKeyAgree.init(clientPair.generateKeyPair().getPrivate());
            shareKeyAgree.doPhase(key, true);
            return Md5Crypto.encryptbuf(Arrays.copyOf(shareKeyAgree.generateSecret(), 16));
        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException | InvalidKeyException |
                 InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

}
