package top.tobing.netty_in_action.ch4;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * $ 基于明文的Java Old IO Server
 * 可以处理中等数量的并发客户端，但不能很好扩展到支撑成千上万的并发接入。
 * @author tobing
 * @date 2022/2/4 19:34
 */
public class PlainOioServer {
    public void server(int port) throws IOException {
        // 将服务器绑定到指定端口
        final ServerSocket socket = new ServerSocket(port);
        try {
            for (; ; ) {
                // 接受连接
                final Socket clientSocket = socket.accept();
                System.out.println("Accept connection from " + clientSocket);
                // 创建一个新的线程处理该连接
                new Thread(() -> {
                    try (OutputStream out = clientSocket.getOutputStream();) {
                        out.write("Hi!\r\n".getBytes(StandardCharsets.UTF_8));
                        out.flush();
                        // 关闭连接
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start(); // 启动线程
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
