package io.ktor.utils.io.core.internal;

import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.PacketJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Unsafe.kt */
/* loaded from: classes5.dex */
public final class UnsafeKt {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f47410a = new byte[0];

    public static final void a(Input input, ChunkBuffer current) {
        boolean z7;
        Intrinsics.f(input, "<this>");
        Intrinsics.f(current, "current");
        if (current == input) {
            return;
        }
        if (current.k() > current.i()) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            input.y(current);
        } else if (current.f() - current.g() < 8) {
            input.X(current);
        } else {
            input.f1(current.i());
        }
    }

    public static final ChunkBuffer b(Input input, int i8) {
        Intrinsics.f(input, "<this>");
        return input.R0(i8);
    }

    public static final ChunkBuffer c(Input input, ChunkBuffer current) {
        Intrinsics.f(input, "<this>");
        Intrinsics.f(current, "current");
        if (current == input) {
            if (input.h()) {
                return (ChunkBuffer) input;
            }
            return null;
        }
        return input.I(current);
    }

    public static final ChunkBuffer d(Output output, int i8, ChunkBuffer chunkBuffer) {
        Intrinsics.f(output, "<this>");
        if (chunkBuffer != null) {
            output.c();
        }
        return output.Z(i8);
    }

    public static final int e(ByteReadPacket byteReadPacket, BytePacketBuilder builder) {
        Intrinsics.f(byteReadPacket, "<this>");
        Intrinsics.f(builder, "builder");
        int P0 = builder.P0();
        ChunkBuffer d02 = builder.d0();
        if (d02 == null) {
            return 0;
        }
        if (P0 <= PacketJVMKt.a() && d02.B() == null && byteReadPacket.o1(d02)) {
            builder.a();
            return P0;
        }
        byteReadPacket.c(d02);
        return P0;
    }
}
