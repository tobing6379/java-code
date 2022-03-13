package top.tobing.netty_in_action.ch4;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.DefaultFileRegion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * $ Netty Zero-copy
 *
 * @author tobing
 * @date 2022/2/20 21:43
 */
public class NettyZeroCopy {
    public static void main(String[] args) throws FileNotFoundException {

        Channel out = null;

        File file = new File("D:/xxx");
        FileOutputStream in = new FileOutputStream(file);
        DefaultFileRegion region = new DefaultFileRegion(in.getChannel(), 0, file.length());
        out.writeAndFlush(region).addListener((ChannelFutureListener) future -> {
            if (!future.isSuccess()) {
                Throwable cause = future.cause();
                // exception handle
            }
        });
    }
}
