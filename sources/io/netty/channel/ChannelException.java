package io.netty.channel;

/* loaded from: classes5.dex */
public class ChannelException extends RuntimeException {
    public ChannelException() {
    }

    public ChannelException(String str, Throwable th) {
        super(str, th);
    }

    public ChannelException(String str) {
        super(str);
    }

    public ChannelException(Throwable th) {
        super(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ChannelException(String str, Throwable th, boolean z7) {
        super(str, th, false, true);
    }
}
