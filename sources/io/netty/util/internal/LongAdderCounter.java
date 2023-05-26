package io.netty.util.internal;

import java.util.concurrent.atomic.LongAdder;

/* loaded from: classes5.dex */
final class LongAdderCounter extends LongAdder implements LongCounter {
    @Override // io.netty.util.internal.LongCounter
    public long value() {
        return longValue();
    }
}
