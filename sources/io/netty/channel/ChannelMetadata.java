package io.netty.channel;

import io.netty.util.internal.ObjectUtil;

/* loaded from: classes5.dex */
public final class ChannelMetadata {
    private final int defaultMaxMessagesPerRead;
    private final boolean hasDisconnect;

    public ChannelMetadata(boolean z7) {
        this(z7, 1);
    }

    public int defaultMaxMessagesPerRead() {
        return this.defaultMaxMessagesPerRead;
    }

    public boolean hasDisconnect() {
        return this.hasDisconnect;
    }

    public ChannelMetadata(boolean z7, int i8) {
        ObjectUtil.checkPositive(i8, "defaultMaxMessagesPerRead");
        this.hasDisconnect = z7;
        this.defaultMaxMessagesPerRead = i8;
    }
}
