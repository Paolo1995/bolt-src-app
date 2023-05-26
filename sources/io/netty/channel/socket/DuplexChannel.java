package io.netty.channel.socket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;

/* loaded from: classes5.dex */
public interface DuplexChannel extends Channel {
    ChannelFuture shutdownOutput();
}
