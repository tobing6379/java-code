package top.tobing.netty_in_action.ch4;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * $ 基于明文的Java New IO Server
 *
 * @author tobing
 * @date 2022/2/4 19:34
 */
public class PlainNioServer {
    public void server(int port) throws IOException {
        // 将服务器绑定到指定端口
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);
        ServerSocket ssocket = serverChannel.socket();
        InetSocketAddress address = new InetSocketAddress(port);
        ssocket.bind(address);
        // 打开Selector处理Channel
        Selector selector = Selector.open();
        // 将ServerSocket注册到Selector以接收连接
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        final ByteBuffer msg = ByteBuffer.wrap("Hi!\r\n".getBytes(StandardCharsets.UTF_8));
        for (; ; ) {
            try {
                // 等待需要处理的新实践，阻塞将一直持续到下一个传入事件
                selector.select();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
            // 获取所有接收时间的SelectionKey
            Set<SelectionKey> readyKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readyKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                // 迭代检查事件是否是一个新的已经就绪可以被接受的连接
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    // 接收客户端并将其注册到选择器
                    SocketChannel client = server.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_WRITE |SelectionKey.OP_READ, msg.duplicate());
                    System.out.println("Accepted connection from " + client);
                }
                // 迭代检查套接字是否已经准备好写数据
                if (key.isWritable()) {
                    SocketChannel client = (SocketChannel) key.channel();
                    // 将数据写到已经连接的客户端
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    while (buffer.hasRemaining()) {
                        if (client.write(buffer)==0) {
                            break;
                        }
                    }
                    // 关闭连接
                    client.close();
                }
            }
        }

    }
}
