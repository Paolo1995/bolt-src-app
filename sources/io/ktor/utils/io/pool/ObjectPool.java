package io.ktor.utils.io.pool;

import java.io.Closeable;

/* compiled from: Pool.kt */
/* loaded from: classes5.dex */
public interface ObjectPool<T> extends Closeable {

    /* compiled from: Pool.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static <T> void a(ObjectPool<T> objectPool) {
            objectPool.dispose();
        }
    }

    void dispose();

    void recycle(T t7);

    T u0();
}
