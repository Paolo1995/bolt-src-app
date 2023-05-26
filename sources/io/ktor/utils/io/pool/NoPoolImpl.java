package io.ktor.utils.io.pool;

import io.ktor.utils.io.pool.ObjectPool;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Pool.kt */
/* loaded from: classes5.dex */
public abstract class NoPoolImpl<T> implements ObjectPool<T> {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ObjectPool.DefaultImpls.a(this);
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public void dispose() {
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public void recycle(T instance) {
        Intrinsics.f(instance, "instance");
    }
}
