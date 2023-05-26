package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;

/* compiled from: BufferFactory.kt */
/* loaded from: classes5.dex */
public final class BufferFactoryKt {

    /* renamed from: a  reason: collision with root package name */
    private static final ObjectPool<ChunkBuffer> f47376a = new DefaultBufferPool(0, 0, null, 7, null);

    public static final ObjectPool<ChunkBuffer> a() {
        return f47376a;
    }
}
