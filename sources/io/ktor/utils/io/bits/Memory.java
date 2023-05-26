package io.ktor.utils.io.bits;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MemoryJvm.kt */
/* loaded from: classes5.dex */
public final class Memory {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f47364a = new Companion(null);

    /* renamed from: b  reason: collision with root package name */
    private static final ByteBuffer f47365b;

    /* compiled from: MemoryJvm.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ByteBuffer a() {
            return Memory.f47365b;
        }
    }

    static {
        ByteBuffer order = ByteBuffer.allocate(0).order(ByteOrder.BIG_ENDIAN);
        Intrinsics.e(order, "allocate(0).order(ByteOrder.BIG_ENDIAN)");
        f47365b = b(order);
    }

    public static ByteBuffer b(ByteBuffer buffer) {
        Intrinsics.f(buffer, "buffer");
        return buffer;
    }

    public static final void c(ByteBuffer byteBuffer, ByteBuffer destination, int i8, int i9, int i10) {
        Intrinsics.f(destination, "destination");
        if (byteBuffer.hasArray() && destination.hasArray() && !byteBuffer.isReadOnly() && !destination.isReadOnly()) {
            System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + i8, destination.array(), destination.arrayOffset() + i10, i9);
            return;
        }
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position(i8);
        duplicate.limit(i8 + i9);
        ByteBuffer duplicate2 = destination.duplicate();
        duplicate2.position(i10);
        duplicate2.put(duplicate);
    }

    public static final ByteBuffer d(ByteBuffer byteBuffer, int i8, int i9) {
        return b(MemoryJvmKt.d(byteBuffer, i8, i9));
    }
}
