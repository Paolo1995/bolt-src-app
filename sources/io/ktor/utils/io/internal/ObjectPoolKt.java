package io.ktor.utils.io.internal;

import io.ktor.utils.io.internal.ReadWriteBufferState;
import io.ktor.utils.io.pool.DefaultPool;
import io.ktor.utils.io.pool.DirectByteBufferPool;
import io.ktor.utils.io.pool.NoPoolImpl;
import io.ktor.utils.io.pool.ObjectPool;
import j$.util.Spliterator;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ObjectPool.kt */
/* loaded from: classes5.dex */
public final class ObjectPoolKt {

    /* renamed from: a  reason: collision with root package name */
    private static final int f47431a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f47432b;

    /* renamed from: c  reason: collision with root package name */
    private static final int f47433c;

    /* renamed from: d  reason: collision with root package name */
    private static final ObjectPool<ByteBuffer> f47434d;

    /* renamed from: e  reason: collision with root package name */
    private static final ObjectPool<ReadWriteBufferState.Initial> f47435e;

    /* renamed from: f  reason: collision with root package name */
    private static final ObjectPool<ReadWriteBufferState.Initial> f47436f;

    static {
        int a8 = UtilsKt.a("BufferSize", 4096);
        f47431a = a8;
        int a9 = UtilsKt.a("BufferPoolSize", 2048);
        f47432b = a9;
        final int a10 = UtilsKt.a("BufferObjectPoolSize", Spliterator.IMMUTABLE);
        f47433c = a10;
        f47434d = new DirectByteBufferPool(a9, a8);
        f47435e = new DefaultPool<ReadWriteBufferState.Initial>(a10) { // from class: io.ktor.utils.io.internal.ObjectPoolKt$BufferObjectPool$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.ktor.utils.io.pool.DefaultPool
            /* renamed from: q */
            public void e(ReadWriteBufferState.Initial instance) {
                Intrinsics.f(instance, "instance");
                ObjectPoolKt.d().recycle(instance.f47439a);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.ktor.utils.io.pool.DefaultPool
            /* renamed from: t */
            public ReadWriteBufferState.Initial h() {
                return new ReadWriteBufferState.Initial(ObjectPoolKt.d().u0(), 0, 2, null);
            }
        };
        f47436f = new NoPoolImpl<ReadWriteBufferState.Initial>() { // from class: io.ktor.utils.io.internal.ObjectPoolKt$BufferObjectNoPool$1
            @Override // io.ktor.utils.io.pool.ObjectPool
            /* renamed from: a */
            public ReadWriteBufferState.Initial u0() {
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(ObjectPoolKt.a());
                Intrinsics.e(allocateDirect, "allocateDirect(BUFFER_SIZE)");
                return new ReadWriteBufferState.Initial(allocateDirect, 0, 2, null);
            }
        };
    }

    public static final int a() {
        return f47431a;
    }

    public static final ObjectPool<ReadWriteBufferState.Initial> b() {
        return f47436f;
    }

    public static final ObjectPool<ReadWriteBufferState.Initial> c() {
        return f47435e;
    }

    public static final ObjectPool<ByteBuffer> d() {
        return f47434d;
    }
}
