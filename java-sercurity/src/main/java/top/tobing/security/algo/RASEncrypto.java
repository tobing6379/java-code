package top.tobing.security.algo;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.*;

/**
 * $ 非对称加密算法
 *
 * @author tobing
 * @date 2022/3/13 15:26
 */
public class RASEncrypto {


    /**
     * 加密算法
     */
    private static final String ALGO = "RSA";
    /**
     * 初始化密钥长度
     */
    private static final int KEY_SIZE = 1024;
    /**
     * 公钥文件路径
     */
    private static final String PUBLIC_KEY_FILE = "/PublicKey";
    /**
     * 私钥文件路径
     */
    private static final String PRIVATE_KEY_FILE = "/PrivateKey";

    public static void main(String[] args) throws Exception {
        generateKeyPair();
        String encryptData = encrypt("Hello world!");
        String rawData = decrypt(encryptData);
        System.out.println(rawData);
    }

    /**
     * 生成密钥对
     */
    protected static void generateKeyPair() throws Exception {
        // 为RSA算法生成一个keyPairGenerator对象
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGO);
        // 利用密钥长度初始化一对密钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // 获取公钥
        PublicKey publicKey = keyPair.getPublic();
        // 获取私钥
        PrivateKey privateKey = keyPair.getPrivate();
        //
        ObjectOutputStream oos1 = null;
        ObjectOutputStream oos2 = null;
        try {
            URL classPath = RASEncrypto.class.getClassLoader().getResource("");
            File publicKeyFile = new File(classPath.getPath() + PUBLIC_KEY_FILE);
            File privateKeyFile = new File(classPath.getPath() + PRIVATE_KEY_FILE);
            if (publicKeyFile.exists()) {
                System.out.println("公私钥已经生成，无需重复生成，path：" + publicKeyFile.getPath());
            }
            oos1 = new ObjectOutputStream(new FileOutputStream(publicKeyFile));
            oos2 = new ObjectOutputStream(new FileOutputStream(privateKeyFile));

            oos1.writeObject(publicKey);
            oos2.writeObject(privateKey);

        } catch (Exception e) {
            throw e;
        } finally {
            if (oos1 != null) {
                oos1.close();
            }
            if (oos2 != null) {
                oos2.close();
            }
        }
    }

    /**
     * 对数据加密，并将加密得到的数据使用Base64编码
     */
    public static String encrypt(String rawData) throws Exception {
        Key publicKey = loadPublicKey();
        Cipher cipher = Cipher.getInstance(ALGO);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptData = cipher.doFinal(rawData.getBytes(StandardCharsets.UTF_8));
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(encryptData);
    }

    private static PublicKey loadPublicKey() throws Exception {
        URL classPath = RASEncrypto.class.getClassLoader().getResource("");
        File publicKeyFile = new File(classPath.getPath() + PUBLIC_KEY_FILE);

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(publicKeyFile))) {
            return (PublicKey) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 对数据解密
     */
    public static String decrypt(String encryptData) throws Exception {
        Key privateKey = loadPrivateKey();
        Cipher cipher = Cipher.getInstance(ALGO);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] encryptDataBytes = base64Decoder.decodeBuffer(encryptData);
        byte[] rawDataBytes
                = cipher.doFinal(encryptDataBytes);
        return new String(rawDataBytes);
    }

    private static PrivateKey loadPrivateKey() throws Exception {
        URL classPath = RASEncrypto.class.getClassLoader().getResource("");
        File privateKeyFile = new File(classPath.getPath() + PRIVATE_KEY_FILE);

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(privateKeyFile))) {
            return (PrivateKey) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
