package top.tobing.netty_in_action.ch4;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * $ 共享EventLoop
 *
 * @author tobing
 * @date 2022/2/15 22:34
 */
public class BootstrapSharedEventLoop {
    public static void main(String[] args) {
        // 创建 ServerBootstrap 以创建ServerSocketChannel，并绑定它
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap
                // 设置EventLoopGroup，其将提供用以处理 Channel 事件的 EventLoop
                .group(new NioEventLoopGroup(), new NioEventLoopGroup())
                // 指定要使用的Channel实现
                .channel(NioServerSocketChannel.class)
                // 设置用于处理已被接受的子Channel的I/O和数据的ChannelInboundHandler
                .childHandler(new SimpleChannelInboundHandler<ByteBuf>() {
                    ChannelFuture connectFuture;

                    @Override
                    public void channelActive(ChannelHandlerContext ctx) throws Exception {
                        // 创建一个新Bootstrap以连接到远程主机
                        Bootstrap bootstrap = new Bootstrap();
                        bootstrap
                                // 指定Channel实现
                                .channel(NioSocketChannel.class)
                                // 为入站I/O设置ChannelInboundHandler
                                .handler(new SimpleChannelInboundHandler<ByteBuf>() {
                                    @Override
                                    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
                                        System.out.println("Received data");
                                    }
                                });
                        // 使用与分配给已被接受的子Channel相同的EventLoop
                        bootstrap.group(ctx.channel().eventLoop());
                        // 连接到远程节点
                        connectFuture = bootstrap.connect(new InetSocketAddress("www.manning.com", 80));
                    }
                    // 连接完成，执行一些数据操作
                    @Override
                    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
                        if (connectFuture.isDone()) {
                            // do something with the data
                        }
                    }
                });

        ChannelFuture future = bootstrap.bind(new InetSocketAddress(8080));
        future.addListener((ChannelFutureListener) channelFuture -> {
            if (channelFuture.isSuccess()) {
                System.out.println("Server bound");
            } else {
                System.err.println("Bind attempt failed");
                channelFuture.cause().printStackTrace();
            }
        });
    }
}
