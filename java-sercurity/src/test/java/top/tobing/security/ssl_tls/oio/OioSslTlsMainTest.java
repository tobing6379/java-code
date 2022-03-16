package top.tobing.security.ssl_tls.oio;

import org.junit.Test;

/**
 * $ OioSslTlsMainTest
 * 测试OIO模式下，基于SSL/TLS通信，先启动服务端{@link EchoServer}，再客户端{@link EchoClient}
 *
 * @author tobing
 * @date 2022/3/16 20:38
 */
public class OioSslTlsMainTest {

    @Test
    public void testStartServer() {
        EchoServer.start();
    }

    @Test
    public void testStartClient() {
        EchoClient.connect();
    }
}
