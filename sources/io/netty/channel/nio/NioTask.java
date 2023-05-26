package io.netty.channel.nio;

import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

/* loaded from: classes5.dex */
public interface NioTask<C extends SelectableChannel> {
    void channelReady(C c8, SelectionKey selectionKey) throws Exception;

    void channelUnregistered(C c8, Throwable th) throws Exception;
}
