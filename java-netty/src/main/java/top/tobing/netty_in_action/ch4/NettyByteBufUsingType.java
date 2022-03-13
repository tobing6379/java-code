package top.tobing.netty_in_action.ch4;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.ByteBuffer;

/**
 * $ Netty ByteBuf Model
 *
 * @author tobing
 * @date 2022/2/12 23:59
 * @description
 */
public class NettyByteBufUsingType {
    public static void main(String[] args) {
    }

    /**
     * $ 复合缓冲区 CompositeByteBuf
     */
    private static void compositeByCompositeByteBuf() {
        CompositeByteBuf messageBuf = Unpooled.compositeBuffer();
        ByteBuf headerBuf = null; // can be backing or direct
        ByteBuf bodyBuf = null;// can be backing or direct
        // 将实例追加到CompositeByteBuf
        messageBuf.addComponents(headerBuf, bodyBuf);
        // 删除位于索引位置为0的ByteBuf
        messageBuf.removeComponent(0);
        // 循环所有的ByteBuf实例
        for (ByteBuf buf : messageBuf) {
            System.out.println(buf.toString());
        }
    }

    /**
     * $ 复合缓冲区 JDK ByteBuffer
     */
    private static void compositeByJDKNIO() {
        ByteBuffer header = null;
        ByteBuffer body = null;
        // Use an array to hold the message parts
        ByteBuffer[] message = new ByteBuffer[]{header, body};
        // Create a new ByteBuffer and use copy to merge the header and body
        ByteBuffer message2 = ByteBuffer.allocate(header.remaining() + body.remaining());
        message2.put(header);
        message2.put(body);
        message2.flip();
    }

    /**
     * 直接缓冲区
     */
    private static void directBuf() {
        ByteBuf directBuf = null;
        // 检查ByteBuf是否由数组支撑。如果不是，则是一个直接缓冲区
        if (!directBuf.hasArray()) {
            // 获取可读字节数
            int length = directBuf.readableBytes();
            // 分配一个新的数组来保存具有该长度的字节数据
            byte[] array = new byte[length];
            // 将直接内存中的字节复制到该数组
            directBuf.getBytes(directBuf.readerIndex(), array);
            // 使用数组、偏移量和长度作为参数调用方法
            handleArray(array, 0, length);
        }
    }

    /**
     * 堆缓冲区
     */
    private static void heapBuf() {
        ByteBuf heapBuf = null;
        // 检查ByteBuf是否有一个支撑数组
        // 如果返回false是尝试访问支撑数组将触发一个UnsupportedOperationException
        if (heapBuf.hasArray()) {
            // 如果有获取对该数组的引用
            byte[] array = heapBuf.array();
            // 计算第一个字节的偏移量
            int offset = heapBuf.arrayOffset() + heapBuf.readerIndex();
            // 获取可读字节数
            int length = heapBuf.readableBytes();
            // 使用数组、偏移量和长度作为参数调用方法
            handleArray(array, offset, length);
        }
    }

    private static void handleArray(byte[] array, int offset, int length) {

    }
}
