package com.osmeet.os.app.utils;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

/**
 * Created by yyj on 2018/12/09.
 * <p>
 * RSA加密。
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class RSAUtil {
    /**
     * 使用私钥加密数据  用一个已打包成byte[]形式的私钥加密数据，即数字签名。
     *
     * @param keyInByte 打包成byte[]的私钥
     * @param source    要签名的数据，一般应是数字摘要
     * @return 签名 byte[]
     */
    public static byte[] sign(byte[] keyInByte, byte[] source) {
        try {
            PKCS8EncodedKeySpec priv_spec = new PKCS8EncodedKeySpec(keyInByte);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyFactory.generatePrivate(priv_spec);
            Signature sig = Signature.getInstance("SHA1withRSA");
            sig.initSign(priKey);
            sig.update(source);
            return sig.sign();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 验证数字签名。
     *
     * @param keyInByte 打包成byte[]形式的公钥
     * @param source    原文的数字摘要
     * @param sign      签名（对原文的数字摘要的签名）
     * @return 是否证实 boolean
     */
    public static boolean verify(byte[] keyInByte, byte[] source, byte[] sign) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            Signature sig = Signature.getInstance("SHA1withRSA");
            X509EncodedKeySpec pub_spec = new X509EncodedKeySpec(keyInByte);
            PublicKey pubKey = keyFactory.generatePublic(pub_spec);
            sig.initVerify(pubKey);
            sig.update(source);
            return sig.verify(sign);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 建立新的密钥对，返回打包的byte[]形式私钥和公钥。
     *
     * @return 包含打包成byte[]形式的私钥和公钥的object[], 其中，object[0]为私钥byte[],object[1]为公钥byte[]
     */
    public static Object[] giveRSAKeyPairInByte() {
        KeyPair newKeyPair = createMyKey();
        if (newKeyPair == null)
            return null;
        Object[] re = new Object[2];
        PrivateKey priKey = newKeyPair.getPrivate();
        byte[] b_pri = priKey.getEncoded();
        PublicKey pub = newKeyPair.getPublic();
        byte[] b_pub = pub.getEncoded();
        re[0] = b_pri;
        re[1] = b_pub;
        return re;
    }

    /**
     * 新建密钥对。
     *
     * @return KeyPair对象
     */
    public static KeyPair createMyKey() {
        KeyPair myPair;
        long mySeed;
        mySeed = System.currentTimeMillis();
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
            random.setSeed(mySeed);
            keyGen.initialize(1024, random);
            myPair = keyGen.generateKeyPair();

        } catch (Exception e1) {
            return null;

        }
        return myPair;
    }

    /**
     * 使用RSA公钥加密数据。
     *
     * @param pubKeyInByte 打包的byte[]形式公钥
     * @param data         要加密的数据
     * @return 加密数据
     */
    public static byte[] encryptByRSA(byte[] pubKeyInByte, byte[] data) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec pub_spec = new X509EncodedKeySpec(pubKeyInByte);
            PublicKey pubKey = keyFactory.generatePublic(pub_spec);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            return cipher.doFinal(data);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * * 用RSA私钥解密
     *
     * @param priKeyInByte  私钥打包成byte[]形式
     * @param data          要解密的数据
     * @return 解密数据
     */
    public static byte[] decryptByRSA(byte[] priKeyInByte, byte[] data) {
        try {
            PKCS8EncodedKeySpec pri_spec = new PKCS8EncodedKeySpec(priKeyInByte);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyFactory.generatePrivate(pri_spec);
//            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, priKey);
            return cipher.doFinal(data);
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 使用RSA私钥加密数据
     *
     * @param priKeyInByte 打包的byte[]形式私钥
     * @param data 要加密的数据
     * @return 加密数据
     */
    public static byte[] encryptByRSA1(byte[] priKeyInByte, byte[] data) {
        try {
            PKCS8EncodedKeySpec private_spec = new PKCS8EncodedKeySpec(
                    priKeyInByte);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyFactory.generatePrivate(private_spec);
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, priKey);
            return cipher.doFinal(data);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 用RSA公钥解密
     *
     * @param pubKeyInByte     公钥打包成byte[]形式
     * @param data             要解密的数据
     * @return 解密数据
     */
    public static byte[] decryptByRSA1(byte[] pubKeyInByte, byte[] data) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec pub_spec = new X509EncodedKeySpec(pubKeyInByte);
            PublicKey pubKey = keyFactory.generatePublic(pub_spec);
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, pubKey);
            return cipher.doFinal(data);
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 计算字符串的SHA数字摘要，以byte[]形式返回
     *
     * @param source .
     * @return 字符串的SHA数字摘要
     */
    public static byte[] digestSHA(String source) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA");
            return md.digest(source.getBytes("UTF-8"));
        } catch (Exception e) {
            return null;
        }
    }

//    public static void main(String[] args) throws Exception {
//        byte[] bytes = RSAUtil.encryptByRSA(Base64Util.decode(RSA.PUBLIC_KEY), "AAAAA".getBytes());
////        byte[] bytes = RSAUtil.encryptByRSA(RSA.PUBLIC_KEY.getBytes(), "AAAAA".getBytes());
//        System.out.print(new String(bytes, "UTF-8"));
//    }

}
