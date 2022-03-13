package top.tobing.sercurity;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

/**
 * $ 对称加密
 *
 * @author tobing
 * @date 2022/3/13 15:11
 */
public class DESCrypto {
    public static void main(String[] args) {
        String key = "12345678";
        String rawData = "hello world!";

        byte[] encrypt = encrypt("DES", rawData.getBytes(StandardCharsets.UTF_8), key);
        byte[] ret = decrypt("DES", encrypt, key);
        System.out.println(new String(ret, StandardCharsets.UTF_8));
    }

    /**
     * 对称加密
     *
     * @param type    对称加密算法
     * @param rawData 未加密数据
     * @param key     加密密钥，长度必须是8的倍数
     * @return 加密数据
     */
    public static byte[] encrypt(String type, byte[] rawData, String key) {
        try {
            // DES要求有一个可靠的随机数源
            SecureRandom random = new SecureRandom();
            // 创建密钥描述符
            DESKeySpec desKeySpec = new DESKeySpec(key.getBytes(StandardCharsets.UTF_8));
            // 创建密钥工厂，将密钥描述符转换为密钥
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(type);
            // 通过密钥工厂将密钥描述符转换为密钥
            SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
            // 使用Cipher完成实际的加密操作
            Cipher cipher = Cipher.getInstance(type);
            // 使用密钥初始化Cipher
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, random);
            // 加密数据
            return cipher.doFinal(rawData);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return null;
    }

    /**
     * 对称解密
     *
     * @param type        对称加密算法
     * @param encryptData 加密数据
     * @param key         加密密钥，长度必须是8的倍数
     * @return 解密数据
     */
    public static byte[] decrypt(String type, byte[] encryptData, String key) {
        try {
            // DES要求有一个可靠的随机数源
            SecureRandom random = new SecureRandom();
            // 创建密钥描述符
            DESKeySpec desKeySpec = new DESKeySpec(key.getBytes(StandardCharsets.UTF_8));
            // 创建密钥工厂，将密钥描述符转换为密钥
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(type);
            // 通过密钥工厂将密钥描述符转换为密钥
            SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
            // 使用Cipher完成实际的加密操作
            Cipher cipher = Cipher.getInstance(type);
            // 使用密钥初始化Cipher
            cipher.init(Cipher.DECRYPT_MODE, secretKey, random);
            // 解密数据
            return cipher.doFinal(encryptData);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return null;
    }
}
