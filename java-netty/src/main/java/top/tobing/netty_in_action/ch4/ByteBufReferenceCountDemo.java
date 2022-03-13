package top.tobing.netty_in_action.ch4;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;

/**
 * $ 引用计数
 *
 * @author tobing
 * @date 2022/2/13 15:30
 */
public class ByteBufReferenceCountDemo {
    public static void main(String[] args) {
        Channel channel = null;
        ByteBufAllocator allocator = channel.alloc();
        ByteBuf buffer = allocator.directBuffer();
        assert buffer.refCnt() == 1;
    }

    public void test() {
        // while (!terminated) {
        //     List<Runnable> readyEvents = blockUntilEventsReady();
        //     for (Runnable ev : readyEvents) {
        //         ev.run();
        //     }
        // }
    }
}
