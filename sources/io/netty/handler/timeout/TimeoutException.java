package io.netty.handler.timeout;

import io.netty.channel.ChannelException;

/* loaded from: classes5.dex */
public class TimeoutException extends ChannelException {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TimeoutException() {
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TimeoutException(boolean z7) {
        super(null, null, z7);
    }
}
