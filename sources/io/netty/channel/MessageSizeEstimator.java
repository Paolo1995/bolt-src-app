package io.netty.channel;

/* loaded from: classes5.dex */
public interface MessageSizeEstimator {

    /* loaded from: classes5.dex */
    public interface Handle {
        int size(Object obj);
    }

    Handle newHandle();
}
