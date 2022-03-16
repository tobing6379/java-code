package top.tobing.security.ssl_tls.oio;

import javax.net.ssl.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;

/**
 * $ OIO安全通信Echo客户端
 *
 * @author tobing
 * @date 2022/3/14 22:59
 */
public class EchoClient {
    private static SSLSocket sslSocket;
    private static OutputStream output;
    private static InputStream input;

    public static void main(String[] args) {
        connect();
    }

    public static void connect() {
        try {
            // 创建服务端SSL上下文实例
            SSLContext clientSSLContext = createClientSSLContext();
            SSLSocketFactory factory = clientSSLContext.getSocketFactory();
            // 通过SSL上下文实例创建服务端SSL监听套接字
            sslSocket = (SSLSocket) factory.createSocket("localhost", 8080);
            // 握手时，由客户端发起Client Hello
            sslSocket.setUseClientMode(true);
            sslSocket.setNeedClientAuth(true);
            System.out.println("服务器连接成功！");
            input = sslSocket.getInputStream();
            output = sslSocket.getOutputStream();
            output.write("hello\r\n\r\n".getBytes(StandardCharsets.UTF_8));
            output.flush();

            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = input.read(buf)) != -1) {
                System.out.println("客户端收到：" + new String(buf, 0, len, StandardCharsets.UTF_8));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeQuietly(output);
            closeQuietly(input);
            closeQuietly(sslSocket);
        }
    }

    private static SSLContext createClientSSLContext() throws Exception {
        // 仓库密钥
        String pwd = "123456";
        String keyStoreFile = "D:\\server.jks";
        char[] passArray = pwd.toCharArray();
        KeyStore keyStore = KeyStore.getInstance("JKS");
        // 加载KeyStoreFile，生成密钥仓库
        FileInputStream inputStream = new FileInputStream(keyStoreFile);
        keyStore.load(inputStream, passArray);
        // 创建密钥管理器，并且初始化
        String algorithm = KeyManagerFactory.getDefaultAlgorithm();
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(algorithm);
        kmf.init(keyStore, passArray);
        // 创建SSLContext并完成初始化
        SSLContext sslContext = SSLContext.getInstance("SSL");
        // 单向认证时，服务端不需要验证客户端的合法性，TrustManager可以为null
        TrustManager[] trustManagers = createTrustManagers(keyStore);
        sslContext.init(kmf.getKeyManagers(), trustManagers, null);

        return sslContext;
    }

    private static TrustManager[] createTrustManagers(KeyStore keyStore) {
        TrustManager[] ret = null;
        try {
            String algorithm = KeyManagerFactory.getDefaultAlgorithm();
            TrustManagerFactory factory = TrustManagerFactory.getInstance(algorithm);
            factory.init(keyStore);
            ret = factory.getTrustManagers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
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
