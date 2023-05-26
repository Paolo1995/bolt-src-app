package io.netty.channel;

import io.netty.util.concurrent.EventExecutor;

/* loaded from: classes5.dex */
final class SucceededChannelFuture extends CompleteChannelFuture {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SucceededChannelFuture(Channel channel, EventExecutor eventExecutor) {
        super(channel, eventExecutor);
    }

    @Override // io.netty.util.concurrent.Future
    public Throwable cause() {
        return null;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean isSuccess() {
        return true;
    }
}
