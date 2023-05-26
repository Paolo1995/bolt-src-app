package io.netty.util.internal;

import java.util.Queue;

/* loaded from: classes5.dex */
public interface PriorityQueue<T> extends Queue<T> {
    void clearIgnoringIndexes();

    boolean removeTyped(T t7);
}
