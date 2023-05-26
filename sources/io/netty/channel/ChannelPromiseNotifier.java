package io.netty.channel;

import io.netty.util.concurrent.PromiseNotifier;

/* loaded from: classes5.dex */
public final class ChannelPromiseNotifier extends PromiseNotifier<Void, ChannelFuture> implements ChannelFutureListener {
    public ChannelPromiseNotifier(boolean z7, ChannelPromise... channelPromiseArr) {
        super(z7, channelPromiseArr);
    }
}
