package top.tobing.security.ssl_tls.oio;

import lombok.extern.slf4j.Slf4j;
import top.tobing.security.util.SSLContextHelper;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * $ OIO安全通信Echo客户端
 *
 * @author tobing
 * @date 2022/3/14 22:59
 */
@Slf4j
public class EchoClient {
    private static SSLSocket sslSocket;
    private static OutputStream output;
    private static InputStream input;

    public static void connect() {
        try {
            // 创建服务端SSL上下文实例
            SSLContext clientSSLContext = SSLContextHelper.createClientSslContext();
            SSLSocketFactory factory = clientSSLContext.getSocketFactory();
            // 通过SSL上下文实例创建服务端SSL监听套接字
            sslSocket = (SSLSocket) factory.createSocket("127.0.0.1", 12345);
            // 握手时，由客户端发起Client Hello
            sslSocket.setUseClientMode(true);

            log.info("Connect server success!");
            input = sslSocket.getInputStream();
            output = sslSocket.getOutputStream();
            output.write("hello\r\n\r\n".getBytes(StandardCharsets.UTF_8));
            output.flush();

            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = input.read(buf)) != -1) {
                log.info("Recv from server : {}", new String(buf, 0, len, StandardCharsets.UTF_8));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeQuietly(output);
            closeQuietly(input);
            closeQuietly(sslSocket);
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
