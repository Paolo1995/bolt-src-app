package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BytePacketBuilder.kt */
/* loaded from: classes5.dex */
public final class BytePacketBuilder extends Output {
    public BytePacketBuilder() {
        this(null, 1, null);
    }

    public /* synthetic */ BytePacketBuilder(ObjectPool<ChunkBuffer> objectPool, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? ChunkBuffer.f47400j.c() : objectPool);
    }

    @Override // io.ktor.utils.io.core.Output
    /* renamed from: D0 */
    public BytePacketBuilder e(char c8) {
        return (BytePacketBuilder) super.append(c8);
    }

    @Override // io.ktor.utils.io.core.Output
    /* renamed from: G0 */
    public BytePacketBuilder g(CharSequence charSequence) {
        return (BytePacketBuilder) super.append(charSequence);
    }

    @Override // io.ktor.utils.io.core.Output
    /* renamed from: I0 */
    public BytePacketBuilder h(CharSequence charSequence, int i8, int i9) {
        return (BytePacketBuilder) super.append(charSequence, i8, i9);
    }

    public final ByteReadPacket K0() {
        int P0 = P0();
        ChunkBuffer d02 = d0();
        if (d02 == null) {
            return ByteReadPacket.f47377n.a();
        }
        return new ByteReadPacket(d02, P0, I());
    }

    public final int P0() {
        return Y();
    }

    public final boolean R0() {
        if (Y() == 0) {
            return true;
        }
        return false;
    }

    @Override // io.ktor.utils.io.core.Output
    protected final void t() {
    }

    public String toString() {
        return "BytePacketBuilder(" + P0() + " bytes written)";
    }

    @Override // io.ktor.utils.io.core.Output
    protected final void w(ByteBuffer source, int i8, int i9) {
        Intrinsics.f(source, "source");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BytePacketBuilder(ObjectPool<ChunkBuffer> pool) {
        super(pool);
        Intrinsics.f(pool, "pool");
    }
}
