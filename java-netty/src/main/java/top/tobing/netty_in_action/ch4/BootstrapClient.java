package top.tobing.netty_in_action.ch4;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author tobing
 * @date 2022/2/15 22:06
 * @description
 */
public class BootstrapClient {
    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();
        // 创建Bootstrap实例以创建和连接新的客户端Channel
        Bootstrap bootstrap = new Bootstrap();
        bootstrap
                // 设置EventLoopGroup，提供用于处理Channel时间的EventLoop
                .group(group)
                // 指定要使用的Channel实现
                .channel(NioSocketChannel.class)
                // 设置用于Channel事件和数据的SimpleChannelInboundHandler
                .handler(new SimpleChannelInboundHandler<ByteBuf>() {
                    @Override
                    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
                        System.out.println("Received data");

                    }
                });
        // 连接到远程主机
        ChannelFuture future = bootstrap.connect(new InetSocketAddress("www.manning.com", 80));
        future.addListener((ChannelFutureListener) channelFuture -> {
            if (channelFuture.isSuccess()) {
                System.out.println("Connection established");
            } else {
                System.err.println("Connection attempt failed");
                channelFuture.cause().printStackTrace();
            }
        });
    }
}
