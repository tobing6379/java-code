package top.tobing.security.ssl_tls.oio;

import lombok.extern.slf4j.Slf4j;
import top.tobing.security.util.SSLContextHelper;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * $ OIO安全通信Echo服务端
 *
 * @author tobing
 * @date 2022/3/14 22:35
 */
@Slf4j
public class EchoServer {

    /**
     * no 8080
     */
    private static final int SOCKET_SERVER_PORT = 12345;
    private static SSLServerSocket serverSocket;

    public static void start() {
        try {
            // 创建服务端SSL上下文实例
            SSLContext serverSSLContext = SSLContextHelper.createServerSslContext();
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
            log.info("Server start success, listen on : {}", SOCKET_SERVER_PORT);
            while (!Thread.interrupted()) {
                Socket client = serverSocket.accept();
                log.info("Client Connect, ip : {}", client.getRemoteSocketAddress());
                OutputStream output = client.getOutputStream();
                InputStream input = client.getInputStream();
                byte[] buf = new byte[1024];
                int len = 0;
                StringBuffer buffer = new StringBuffer();
                while ((len = input.read(buf)) != -1) {
                    String sf = new String(buf, 0, len, StandardCharsets.UTF_8);
                    log.info("Recv from client：{}", sf);
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
