package io.netty.channel.socket;

import java.io.IOException;

/* loaded from: classes5.dex */
public final class ChannelOutputShutdownException extends IOException {
    public ChannelOutputShutdownException(String str) {
        super(str);
    }

    public ChannelOutputShutdownException(String str, Throwable th) {
        super(str, th);
    }
}
