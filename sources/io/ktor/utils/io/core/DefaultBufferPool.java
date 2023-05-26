package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.Allocator;
import io.ktor.utils.io.bits.DefaultAllocator;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.DefaultPool;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BufferFactory.kt */
/* loaded from: classes5.dex */
public final class DefaultBufferPool extends DefaultPool<ChunkBuffer> {

    /* renamed from: m  reason: collision with root package name */
    private final int f47381m;

    /* renamed from: n  reason: collision with root package name */
    private final Allocator f47382n;

    public DefaultBufferPool() {
        this(0, 0, null, 7, null);
    }

    public /* synthetic */ DefaultBufferPool(int i8, int i9, Allocator allocator, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? 4096 : i8, (i10 & 2) != 0 ? 1000 : i9, (i10 & 4) != 0 ? DefaultAllocator.f47363a : allocator);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.ktor.utils.io.pool.DefaultPool
    /* renamed from: q */
    public ChunkBuffer c(ChunkBuffer instance) {
        Intrinsics.f(instance, "instance");
        ChunkBuffer chunkBuffer = (ChunkBuffer) super.c(instance);
        chunkBuffer.I();
        chunkBuffer.r();
        return chunkBuffer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.ktor.utils.io.pool.DefaultPool
    /* renamed from: t */
    public void e(ChunkBuffer instance) {
        Intrinsics.f(instance, "instance");
        this.f47382n.a(instance.h());
        super.e(instance);
        instance.H();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.ktor.utils.io.pool.DefaultPool
    /* renamed from: w */
    public ChunkBuffer h() {
        return new ChunkBuffer(this.f47382n.b(this.f47381m), null, this, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.ktor.utils.io.pool.DefaultPool
    /* renamed from: y */
    public void m(ChunkBuffer instance) {
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        Intrinsics.f(instance, "instance");
        super.m(instance);
        boolean z12 = true;
        if (instance.h().limit() == this.f47381m) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (instance != ChunkBuffer.f47400j.a()) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                if (instance != Buffer.f47369g.a()) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (z9) {
                    if (instance.D() == 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        if (instance.B() == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z11) {
                            if (instance.C() != null) {
                                z12 = false;
                            }
                            if (z12) {
                                return;
                            }
                            throw new IllegalStateException("Recycled instance shouldn't be a view or another buffer.".toString());
                        }
                        throw new IllegalStateException("Recycled instance shouldn't be a part of a chain.".toString());
                    }
                    throw new IllegalStateException("Unable to clear buffer: it is still in use.".toString());
                }
                throw new IllegalStateException("Empty instance couldn't be recycled".toString());
            }
            throw new IllegalStateException("ChunkBuffer.Empty couldn't be recycled".toString());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Buffer size mismatch. Expected: ");
        sb.append(this.f47381m);
        sb.append(", actual: ");
        sb.append(instance.h().limit());
        throw new IllegalStateException(sb.toString().toString());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultBufferPool(int i8, int i9, Allocator allocator) {
        super(i9);
        Intrinsics.f(allocator, "allocator");
        this.f47381m = i8;
        this.f47382n = allocator;
    }
}
