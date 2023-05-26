package io.netty.channel;

import io.netty.util.IntSupplier;

/* loaded from: classes5.dex */
final class DefaultSelectStrategy implements SelectStrategy {
    static final SelectStrategy INSTANCE = new DefaultSelectStrategy();

    private DefaultSelectStrategy() {
    }

    @Override // io.netty.channel.SelectStrategy
    public int calculateStrategy(IntSupplier intSupplier, boolean z7) throws Exception {
        if (z7) {
            return intSupplier.get();
        }
        return -1;
    }
}
