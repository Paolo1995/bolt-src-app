package io.netty.util.concurrent;

/* loaded from: classes5.dex */
public interface ProgressivePromise<V> extends Promise<V>, Future {
    boolean tryProgress(long j8, long j9);
}
