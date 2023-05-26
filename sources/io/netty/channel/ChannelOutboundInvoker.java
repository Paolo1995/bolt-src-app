package io.netty.channel;

import java.net.SocketAddress;

/* loaded from: classes5.dex */
public interface ChannelOutboundInvoker {
    ChannelFuture close();

    ChannelFuture close(ChannelPromise channelPromise);

    ChannelFuture connect(SocketAddress socketAddress, ChannelPromise channelPromise);

    ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise);

    ChannelFuture disconnect(ChannelPromise channelPromise);

    ChannelFuture newFailedFuture(Throwable th);

    ChannelPromise newPromise();

    ChannelPromise voidPromise();

    ChannelFuture write(Object obj);

    ChannelFuture write(Object obj, ChannelPromise channelPromise);

    ChannelFuture writeAndFlush(Object obj);

    ChannelFuture writeAndFlush(Object obj, ChannelPromise channelPromise);
}
