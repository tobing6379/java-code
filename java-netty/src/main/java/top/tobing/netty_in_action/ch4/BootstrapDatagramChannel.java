package top.tobing.netty_in_action.ch4;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.oio.OioDatagramChannel;

import java.net.InetSocketAddress;

/**
 * @author tobing
 * @date 2022/2/15 23:05
 * @description
 */
public class BootstrapDatagramChannel {
    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(new OioEventLoopGroup())
                .channel(OioDatagramChannel.class)
                .handler(new SimpleChannelInboundHandler<DatagramPacket>() {
                             @Override
                             public void channelRead0(ChannelHandlerContext ctx,
                                                      DatagramPacket msg) throws Exception {
                                 // Do something with the packet
                             }
                         }
                );
        ChannelFuture future = bootstrap.bind(new InetSocketAddress(0));
        future.addListener((ChannelFutureListener) channelFuture -> {
            if (channelFuture.isSuccess()) {
                System.out.println("Channel bound");
            } else {
                System.err.println("Bind attempt failed");
                channelFuture.cause().printStackTrace();
            }
        });
    }
}
