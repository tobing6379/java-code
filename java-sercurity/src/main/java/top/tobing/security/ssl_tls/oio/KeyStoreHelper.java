package top.tobing.security.ssl_tls.oio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;

/**
 * $ KeyStoreHelper
 *
 * @author tobing
 * @date 2022/3/15 22:10
 * @see <a herf=""></a>
 */
public class KeyStoreHelper {
    private static final byte[] CRLF = new byte[]{'\r', '\n'};
    private static String keyType = "JKS";
    /**
     * KeyStore文件路径
     */
    private String keyStoreFile;
    /**
     * 获取KeyStore密码
     */
    private String storePass;
    /**
     * 私钥原始密码
     */
    private String keyPass;
    /**
     * KeyStore别名（不区分大小写）
     */
    private String alias;
    /**
     * 证书所有者信息
     * 如："CN=名字与形式,OU=组织单位名称,O=组织名称,L=城市或区域名称,ST=州或省份名称,C=使用两个字母或地区代码"
     */
    private String dname;

    public KeyStoreHelper(String keyStoreFile,
                          String storePass,
                          String keyPass,
                          String alias,
                          String dname) {
        this.keyStoreFile = keyStoreFile;
        this.storePass = storePass;
        this.keyPass = keyPass;
        this.alias = alias;
        this.dname = dname;
    }

    public void createKeyEntry() throws Exception {
        KeyStore keyStore = loadStore();
        Certificate certificate = keyStore.getCertificate(dname);
        try (FileOutputStream fos = new FileOutputStream(keyStoreFile)) {
            keyStore.store(fos, storePass.toCharArray());
        }
    }

    /**
     * 从文件系统中加载KeyStore密钥库
     */
    public KeyStore loadStore() throws Exception {
        System.out.println("KeyStoreFile: " + keyStoreFile);
        File file = new File(keyStoreFile);
        if (!file.exists()) {
            createEmptyStore();
        }
        KeyStore keyStore = KeyStore.getInstance(keyType);
        try (FileInputStream fis = new FileInputStream(keyStoreFile)) {
            keyStore.load(fis, storePass.toCharArray());
        }
        return keyStore;
    }

    /**
     * 创建空的 KeyStore
     */
    private void createEmptyStore() throws Exception {
        KeyStore keyStore = KeyStore.getInstance(keyType);
        File parentFile = new File(keyStoreFile).getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        keyStore.load(null, storePass.toCharArray());
        try (FileOutputStream fos = new FileOutputStream(keyStoreFile)) {
            keyStore.store(fos, storePass.toCharArray());
        }
    }
}
