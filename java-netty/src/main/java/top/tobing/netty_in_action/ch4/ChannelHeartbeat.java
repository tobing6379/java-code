package top.tobing.netty_in_action.ch4;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

import java.nio.charset.StandardCharsets;

/**
 * $ 连接管理
 *
 * @author tobing
 * @date 2022/2/20 15:37
 * @description
 */
public class ChannelHeartbeat {

static final class HeartbeatHandler extends ChannelInboundHandlerAdapter {

    /**
     * 心跳消息
     */
    private static final ByteBuf HEARTBEAT_SEQUENCE = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("HEARTBEAT", StandardCharsets.ISO_8859_1));

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            ctx
                    // 发送心跳消息
                    .writeAndFlush(HEARTBEAT_SEQUENCE.duplicate())
                    // 发送失败时关闭连接
                    .addListener(ChannelFutureListener.CLOSE_ON_FAILURE);

        } else {
            // 非 IdleStateEvent 事件将传递给下一个 ChannelInboundHandlerAdapter
            super.userEventTriggered(ctx, evt);
        }
    }
}
}
