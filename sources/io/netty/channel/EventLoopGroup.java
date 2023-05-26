package io.netty.channel;

import io.netty.util.concurrent.EventExecutorGroup;

/* loaded from: classes5.dex */
public interface EventLoopGroup extends EventExecutorGroup {
    ChannelFuture register(Channel channel);
}
