package top.tobing.security.util;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;

/**
 * $ SSLContextHelper
 *
 * @author tobing
 * @date 2022/3/16 19:56
 */
public class SSLContextHelper {


    /**
     * 创建客户端 SSLContext
     */
    public static SSLContext createClientSslContext() throws Exception {
        // 仓库密钥
        String pwd = "123456";
        String keyStoreFile = "D:\\client.jks";
        return creatSslContext(pwd, keyStoreFile);
    }

    /**
     * 创建服务端 SSLContext
     */
    public static SSLContext createServerSslContext() throws Exception {
        // 仓库密钥
        String pwd = "123456";
        String keyStoreFile = "D:\\server.jks";
        return creatSslContext(pwd, keyStoreFile);
    }

    private static SSLContext creatSslContext(String password, String keyStoreFile) throws Exception {
        char[] passArray = password.toCharArray();
        KeyStore keyStore = KeyStore.getInstance("JKS");
        // 加载KeyStoreFile，生成密钥仓库
        FileInputStream inputStream = new FileInputStream(keyStoreFile);
        keyStore.load(inputStream, passArray);
        SSLContext sslContext = createSslContext(passArray, keyStore);
        closeQuietly(inputStream);
        return sslContext;
    }

    private static SSLContext createSslContext(char[] passwordArray, KeyStore keyStore) throws Exception {
        // 创建密钥管理器，并且初始化
        String algorithm = KeyManagerFactory.getDefaultAlgorithm();
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(algorithm);
        kmf.init(keyStore, passwordArray);
        // 创建SSLContext并完成初始化
        SSLContext sslContext = SSLContext.getInstance("SSL");
        // 单向认证时，服务端不需要验证客户端的合法性，TrustManager可以为null
        X509TrustManagerFacade x509TrustManager = new X509TrustManagerFacade();
        x509TrustManager.init(keyStore);
        X509TrustManager[] trustManagers = {x509TrustManager};
        // 不设置安全随机数
        sslContext.init(kmf.getKeyManagers(), trustManagers, null);

        return sslContext;
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
