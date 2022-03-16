package top.tobing.security.ssl_tls.oio;

import javax.net.ssl.*;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;

/**
 * $ OIO安全通信Echo服务端
 *
 * @author tobing
 * @date 2022/3/14 22:35
 */
public class EchoServer {

    public static void main(String[] args) {
        start();
    }

    private static final int SOCKET_SERVER_PORT = 8080;
    private static SSLServerSocket serverSocket;

    public static void start() {
        try {
            // 创建服务端SSL上下文实例
            SSLContext serverSSLContext = createServerSSLContext();
            SSLServerSocketFactory sslServerSocketFactory = serverSSLContext.getServerSocketFactory();
            // 通过SSL上下文实例创建服务端SSL监听套接字
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(SOCKET_SERVER_PORT);
            // 服务端不需要验证对端身份
            serverSocket.setNeedClientAuth(true);
            // 握手时，使用服务端模式，由客户端发起Client Hello
            serverSocket.setUseClientMode(false);
            String[] supported = serverSocket.getEnabledCipherSuites();
            serverSocket.setEnabledCipherSuites(supported);
            // 监听和接收客户端连接
            while (!Thread.interrupted()) {
                Socket client = serverSocket.accept();
                System.out.println(client.getRemoteSocketAddress());
                OutputStream output = client.getOutputStream();
                InputStream input = client.getInputStream();
                byte[] buf = new byte[1024];
                int len = 0;
                StringBuffer buffer = new StringBuffer();
                while ((len = input.read(buf)) != -1) {
                    String sf = new String(buf, 0, len, StandardCharsets.UTF_8);
                    System.out.println("服务端收到：" + sf);
                    buffer.append(sf);
                    if (sf.contains("\r\n\r\n")) {
                        break;
                    }
                }
                output.write(buffer.toString().getBytes(StandardCharsets.UTF_8));
                output.flush();
                // 关闭socket连接
                closeQuietly(input);
                closeQuietly(output);
                closeQuietly(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeQuietly(serverSocket);
        }
    }

    private static SSLContext createServerSSLContext() throws Exception {
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
        sslContext.init(kmf.getKeyManagers(), createTrustManagers(keyStore), null);

        return sslContext;
    }

    private static TrustManager[] createTrustManagers(KeyStore keyStore) {
        TrustManager[] ret = new TrustManager[0];
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
