package top.tobing.netty_in_action.ch4;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;

import javax.net.ssl.SSLEngine;

/**
 * $ 添加 SSL/TLS 支持
 *
 * @author tobing
 * @date 2022/2/20 15:15
 * @description
 */
public class ChannelSupportSSLOrTLS {


static class SslChannelInitializer extends ChannelInitializer<Channel> {

    private final SslContext context;
    private final boolean startTls;

    /**
     * @param context  传入使用的SslContext
     * @param startTls true表示第一个写入的消息不会被加密
     */
    public SslChannelInitializer(SslContext context, boolean startTls) {
        this.context = context;
        this.startTls = startTls;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        // 对于每个 SslHandler 实例，都使用 Channel 的 ByteBufAllocator 从 SslContext 获取一个新的 SSLEngine
        SSLEngine engine = context.newEngine(ch.alloc());
        // 将SslHandler 作为第一个 ChannelHandler 添加到 ChannelPipeline 中
        ch.pipeline().addFirst("ssl", new SslHandler(engine, startTls));
    }
}
}
