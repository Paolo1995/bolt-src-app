package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteReadPacket.kt */
/* loaded from: classes5.dex */
public final class ByteReadPacket extends Input {

    /* renamed from: n  reason: collision with root package name */
    public static final Companion f47377n = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private static final ByteReadPacket f47378o;

    /* compiled from: ByteReadPacket.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ByteReadPacket a() {
            return ByteReadPacket.f47378o;
        }
    }

    static {
        ChunkBuffer.Companion companion = ChunkBuffer.f47400j;
        f47378o = new ByteReadPacket(companion.a(), 0L, companion.b());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteReadPacket(ChunkBuffer head, long j8, ObjectPool<ChunkBuffer> pool) {
        super(head, j8, pool);
        Intrinsics.f(head, "head");
        Intrinsics.f(pool, "pool");
        D0();
    }

    @Override // io.ktor.utils.io.core.Input
    protected final ChunkBuffer N() {
        return null;
    }

    @Override // io.ktor.utils.io.core.Input
    protected final int O(ByteBuffer destination, int i8, int i9) {
        Intrinsics.f(destination, "destination");
        return 0;
    }

    @Override // io.ktor.utils.io.core.Input
    protected final void j() {
    }

    public final ByteReadPacket q1() {
        return new ByteReadPacket(BuffersKt.a(d0()), C0(), v0());
    }

    public String toString() {
        return "ByteReadPacket(" + C0() + " bytes remaining)";
    }
}
