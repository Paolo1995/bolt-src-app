package io.netty.channel;

import io.netty.util.IntSupplier;

/* loaded from: classes5.dex */
public interface SelectStrategy {
    int calculateStrategy(IntSupplier intSupplier, boolean z7) throws Exception;
}
