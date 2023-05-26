package io.netty.channel.socket;

import io.netty.channel.ChannelConfig;

/* loaded from: classes5.dex */
public interface SocketChannelConfig extends ChannelConfig {
    int getSoLinger();

    boolean isAllowHalfClosure();

    SocketChannelConfig setAutoClose(boolean z7);

    SocketChannelConfig setConnectTimeoutMillis(int i8);

    SocketChannelConfig setKeepAlive(boolean z7);

    SocketChannelConfig setTcpNoDelay(boolean z7);
}
