package top.tobing.security.algo;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * $ 单向加密
 *
 * @author tobing
 * @date 2022/3/13 14:49
 */
public class HashCrypto {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        String plain = "hello world!";

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        MessageDigest sha512 = MessageDigest.getInstance("SHA-512");

        String dest1 = encrypt(md5, plain);
        String dest2 = encrypt(md5, "hello world!");
        String dest3 = encrypt(md5, "hello world123");

        System.out.println(dest1.equals(dest2));
        System.out.println(dest1.equals(dest3));


    }

    public static String encrypt(MessageDigest md, String plain) {
        if (md == null || plain == null) {
            return new String();
        }
        byte[] source = plain.getBytes(StandardCharsets.UTF_8);
        StringBuilder builder = new StringBuilder(32);

        byte[] array = md.digest(source);
        for (int i = 0; i < array.length; i++) {
            String hexString = Integer.toHexString((0x000000FF & array[i]) | 0xFFFFFF00);
            // System.out.printf("hexString：%s，第6位之后：%s\n", hexString, hexString.substring(6));
            builder.append(hexString.substring(6));
        }
        return builder.toString();
    }
}
