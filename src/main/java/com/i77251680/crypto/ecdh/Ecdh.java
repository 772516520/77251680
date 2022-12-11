package com.i77251680.crypto.ecdh;

import com.i77251680.crypto.md5.Md5Crypto;
import com.i77251680.utils.ArrayUtils;
import com.i77251680.utils.HexFormat;

import javax.crypto.KeyAgreement;
import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;

public class Ecdh {
    private final String i77251680_PUBLIC_KEY = "04EBCA94D733E399B2DB96EACDD3F69A8BB0F74224E2B44E3357812211D2E62EFBC91BB553098E25E33A799ADC7F76FEB208DA7C6522CDB0719A305180CC54A82E";
    private final byte[] X509_PREFIX = HexFormat.of().parseHex("3059301306072A8648CE3D020106082A8648CE3D030107034200");
    private final byte[] byteKey = ArrayUtils.concat(X509_PREFIX, HexFormat.of().parseHex(i77251680_PUBLIC_KEY));
    private final PublicKey key;
    private final KeyPairGenerator clientPair;
    KeyPair keyPair;

    public final byte[] publicKey;
    public final byte[] shareKey;

    public Ecdh() {
        try {
            key = KeyFactory.getInstance("EC")
                    .generatePublic(new X509EncodedKeySpec(byteKey));
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        try {
            clientPair = KeyPairGenerator.getInstance("EC");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        try {
            clientPair.initialize(new ECGenParameterSpec("secp256r1"));
        } catch (InvalidAlgorithmParameterException e) {
            throw new RuntimeException(e);
        }
        keyPair = clientPair.genKeyPair();
        this.shareKey = generateShareKey();
        this.publicKey = generatePublicKey();
    }

    private byte[] generateShareKey() {
        try {
            KeyAgreement shareKeyAgree = KeyAgreement.getInstance("ECDH");
            shareKeyAgree.init(keyPair.getPrivate());
            shareKeyAgree.doPhase(key, true);
            return Md5Crypto.encrypt(Arrays.copyOf(shareKeyAgree.generateSecret(), 16));
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] generatePublicKey() {
        return Arrays.copyOfRange(keyPair.getPublic().getEncoded(), 26, 91);
    }

}
