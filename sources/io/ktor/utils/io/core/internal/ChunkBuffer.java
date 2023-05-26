package io.ktor.utils.io.core.internal;

import androidx.concurrent.futures.a;
import io.ktor.utils.io.bits.DefaultAllocator;
import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.BufferFactoryKt;
import io.ktor.utils.io.pool.NoPoolImpl;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChunkBuffer.kt */
/* loaded from: classes5.dex */
public class ChunkBuffer extends Buffer {

    /* renamed from: k  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f47401k;

    /* renamed from: l  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f47402l;

    /* renamed from: n  reason: collision with root package name */
    private static final ObjectPool<ChunkBuffer> f47404n;

    /* renamed from: o  reason: collision with root package name */
    private static final ChunkBuffer f47405o;

    /* renamed from: p  reason: collision with root package name */
    private static final ObjectPool<ChunkBuffer> f47406p;

    /* renamed from: q  reason: collision with root package name */
    private static final ObjectPool<ChunkBuffer> f47407q;

    /* renamed from: h  reason: collision with root package name */
    private final ObjectPool<ChunkBuffer> f47408h;

    /* renamed from: i  reason: collision with root package name */
    private ChunkBuffer f47409i;
    private volatile /* synthetic */ Object nextRef;
    private volatile /* synthetic */ int refCount;

    /* renamed from: j  reason: collision with root package name */
    public static final Companion f47400j = new Companion(null);

    /* renamed from: m  reason: collision with root package name */
    private static final ObjectPool<ChunkBuffer> f47403m = new ObjectPool<ChunkBuffer>() { // from class: io.ktor.utils.io.core.internal.ChunkBuffer$Companion$Pool$1
        @Override // io.ktor.utils.io.pool.ObjectPool
        /* renamed from: a */
        public ChunkBuffer u0() {
            return BufferFactoryKt.a().u0();
        }

        @Override // io.ktor.utils.io.pool.ObjectPool
        /* renamed from: c */
        public void recycle(ChunkBuffer instance) {
            Intrinsics.f(instance, "instance");
            BufferFactoryKt.a().recycle(instance);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            ObjectPool.DefaultImpls.a(this);
        }

        @Override // io.ktor.utils.io.pool.ObjectPool
        public void dispose() {
            BufferFactoryKt.a().dispose();
        }
    };

    /* compiled from: ChunkBuffer.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ChunkBuffer a() {
            return ChunkBuffer.f47405o;
        }

        public final ObjectPool<ChunkBuffer> b() {
            return ChunkBuffer.f47404n;
        }

        public final ObjectPool<ChunkBuffer> c() {
            return ChunkBuffer.f47403m;
        }
    }

    static {
        ObjectPool<ChunkBuffer> objectPool = new ObjectPool<ChunkBuffer>() { // from class: io.ktor.utils.io.core.internal.ChunkBuffer$Companion$EmptyPool$1
            @Override // io.ktor.utils.io.pool.ObjectPool
            /* renamed from: a */
            public ChunkBuffer u0() {
                return ChunkBuffer.f47400j.a();
            }

            @Override // io.ktor.utils.io.pool.ObjectPool
            /* renamed from: c */
            public void recycle(ChunkBuffer instance) {
                boolean z7;
                Intrinsics.f(instance, "instance");
                if (instance == ChunkBuffer.f47400j.a()) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    return;
                }
                throw new IllegalArgumentException("Only ChunkBuffer.Empty instance could be recycled.".toString());
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                ObjectPool.DefaultImpls.a(this);
            }

            @Override // io.ktor.utils.io.pool.ObjectPool
            public void dispose() {
            }
        };
        f47404n = objectPool;
        f47405o = new ChunkBuffer(Memory.f47364a.a(), null, objectPool, null);
        f47406p = new NoPoolImpl<ChunkBuffer>() { // from class: io.ktor.utils.io.core.internal.ChunkBuffer$Companion$NoPool$1
            @Override // io.ktor.utils.io.pool.ObjectPool
            /* renamed from: a */
            public ChunkBuffer u0() {
                return new ChunkBuffer(DefaultAllocator.f47363a.b(4096), null, this, null);
            }

            @Override // io.ktor.utils.io.pool.NoPoolImpl, io.ktor.utils.io.pool.ObjectPool
            /* renamed from: c */
            public void recycle(ChunkBuffer instance) {
                Intrinsics.f(instance, "instance");
                DefaultAllocator.f47363a.a(instance.h());
            }
        };
        f47407q = new NoPoolImpl<ChunkBuffer>() { // from class: io.ktor.utils.io.core.internal.ChunkBuffer$Companion$NoPoolManuallyManaged$1
            @Override // io.ktor.utils.io.pool.ObjectPool
            /* renamed from: a */
            public ChunkBuffer u0() {
                throw new UnsupportedOperationException("This pool doesn't support borrow");
            }

            @Override // io.ktor.utils.io.pool.NoPoolImpl, io.ktor.utils.io.pool.ObjectPool
            /* renamed from: c */
            public void recycle(ChunkBuffer instance) {
                Intrinsics.f(instance, "instance");
            }
        };
        f47401k = AtomicReferenceFieldUpdater.newUpdater(ChunkBuffer.class, Object.class, "nextRef");
        f47402l = AtomicIntegerFieldUpdater.newUpdater(ChunkBuffer.class, "refCount");
    }

    private ChunkBuffer(ByteBuffer byteBuffer, ChunkBuffer chunkBuffer, ObjectPool<ChunkBuffer> objectPool) {
        super(byteBuffer, null);
        boolean z7;
        this.f47408h = objectPool;
        if (chunkBuffer != this) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            this.nextRef = null;
            this.refCount = 1;
            this.f47409i = chunkBuffer;
            return;
        }
        throw new IllegalArgumentException("A chunk couldn't be a view of itself.".toString());
    }

    public /* synthetic */ ChunkBuffer(ByteBuffer byteBuffer, ChunkBuffer chunkBuffer, ObjectPool objectPool, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteBuffer, chunkBuffer, objectPool);
    }

    private final void y(ChunkBuffer chunkBuffer) {
        if (a.a(f47401k, this, null, chunkBuffer)) {
            return;
        }
        throw new IllegalStateException("This chunk has already a next chunk.");
    }

    public ChunkBuffer A() {
        ChunkBuffer chunkBuffer = this.f47409i;
        if (chunkBuffer == null) {
            chunkBuffer = this;
        }
        chunkBuffer.x();
        ChunkBuffer chunkBuffer2 = new ChunkBuffer(h(), chunkBuffer, this.f47408h, null);
        e(chunkBuffer2);
        return chunkBuffer2;
    }

    public final ChunkBuffer B() {
        return (ChunkBuffer) this.nextRef;
    }

    public final ChunkBuffer C() {
        return this.f47409i;
    }

    public final int D() {
        return this.refCount;
    }

    public void E(ObjectPool<ChunkBuffer> pool) {
        Intrinsics.f(pool, "pool");
        if (F()) {
            ChunkBuffer chunkBuffer = this.f47409i;
            if (chunkBuffer != null) {
                H();
                chunkBuffer.E(pool);
                return;
            }
            ObjectPool<ChunkBuffer> objectPool = this.f47408h;
            if (objectPool != null) {
                pool = objectPool;
            }
            pool.recycle(this);
        }
    }

    public final boolean F() {
        int i8;
        int i9;
        do {
            i8 = this.refCount;
            if (i8 > 0) {
                i9 = i8 - 1;
            } else {
                throw new IllegalStateException("Unable to release: it is already released.");
            }
        } while (!f47402l.compareAndSet(this, i8, i9));
        if (i9 == 0) {
            return true;
        }
        return false;
    }

    public final void G(ChunkBuffer chunkBuffer) {
        if (chunkBuffer == null) {
            z();
        } else {
            y(chunkBuffer);
        }
    }

    public final void H() {
        if (f47402l.compareAndSet(this, 0, -1)) {
            z();
            this.f47409i = null;
            return;
        }
        throw new IllegalStateException("Unable to unlink: buffer is in use.");
    }

    public final void I() {
        int i8;
        do {
            i8 = this.refCount;
            if (i8 >= 0) {
                if (i8 > 0) {
                    throw new IllegalStateException("This instance is already in use but somehow appeared in the pool.");
                }
            } else {
                throw new IllegalStateException("This instance is already disposed and couldn't be borrowed.");
            }
        } while (!f47402l.compareAndSet(this, i8, 1));
    }

    @Override // io.ktor.utils.io.core.Buffer
    public final void r() {
        boolean z7;
        if (this.f47409i == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            super.r();
            this.nextRef = null;
            return;
        }
        throw new IllegalArgumentException("Unable to reset buffer with origin".toString());
    }

    public final void x() {
        int i8;
        do {
            i8 = this.refCount;
            if (i8 > 0) {
            } else {
                throw new IllegalStateException("Unable to acquire chunk: it is already released.");
            }
        } while (!f47402l.compareAndSet(this, i8, i8 + 1));
    }

    public final ChunkBuffer z() {
        return (ChunkBuffer) f47401k.getAndSet(this, null);
    }
}
