package m0;

import com.hivemq.client.internal.netty.DefaultChannelOutboundHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import java.net.SocketAddress;

/* compiled from: DefaultChannelOutboundHandler.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class a {
    public static void a(DefaultChannelOutboundHandler defaultChannelOutboundHandler, ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        channelHandlerContext.close(channelPromise);
    }

    public static void b(DefaultChannelOutboundHandler defaultChannelOutboundHandler, ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
        channelHandlerContext.connect(socketAddress, socketAddress2, channelPromise);
    }

    public static void c(DefaultChannelOutboundHandler defaultChannelOutboundHandler, ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        channelHandlerContext.disconnect(channelPromise);
    }

    public static void d(DefaultChannelOutboundHandler defaultChannelOutboundHandler, ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.flush();
    }

    public static void e(DefaultChannelOutboundHandler defaultChannelOutboundHandler, ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.read();
    }

    public static void f(DefaultChannelOutboundHandler defaultChannelOutboundHandler, ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        channelHandlerContext.write(obj, channelPromise);
    }
}
