package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/* loaded from: classes5.dex */
public interface RecvByteBufAllocator {

    @Deprecated
    /* loaded from: classes5.dex */
    public interface Handle {
        ByteBuf allocate(ByteBufAllocator byteBufAllocator);

        int attemptedBytesRead();

        void attemptedBytesRead(int i8);

        boolean continueReading();

        int guess();

        void incMessagesRead(int i8);

        int lastBytesRead();

        void lastBytesRead(int i8);

        void readComplete();

        void reset(ChannelConfig channelConfig);
    }

    Handle newHandle();
}
