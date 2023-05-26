package io.ktor.utils.io.bits;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MemoryJvm.kt */
/* loaded from: classes5.dex */
public final class MemoryJvmKt {
    public static final void a(ByteBuffer copyTo, ByteBuffer destination, int i8) {
        Intrinsics.f(copyTo, "$this$copyTo");
        Intrinsics.f(destination, "destination");
        int remaining = destination.remaining();
        if (copyTo.hasArray() && !copyTo.isReadOnly() && destination.hasArray() && !destination.isReadOnly()) {
            int position = destination.position();
            System.arraycopy(copyTo.array(), copyTo.arrayOffset() + i8, destination.array(), destination.arrayOffset() + position, remaining);
            destination.position(position + remaining);
            return;
        }
        ByteBuffer duplicate = copyTo.duplicate();
        duplicate.limit(remaining + i8);
        duplicate.position(i8);
        destination.put(duplicate);
    }

    public static final void b(ByteBuffer copyTo, byte[] destination, int i8, int i9, int i10) {
        Intrinsics.f(copyTo, "$this$copyTo");
        Intrinsics.f(destination, "destination");
        if (copyTo.hasArray() && !copyTo.isReadOnly()) {
            System.arraycopy(copyTo.array(), copyTo.arrayOffset() + i8, destination, i10, i9);
        } else {
            copyTo.duplicate().get(destination, i10, i9);
        }
    }

    public static final void c(ByteBuffer copyTo, ByteBuffer destination, int i8) {
        Intrinsics.f(copyTo, "$this$copyTo");
        Intrinsics.f(destination, "destination");
        if (copyTo.hasArray() && !copyTo.isReadOnly()) {
            byte[] array = copyTo.array();
            Intrinsics.e(array, "array()");
            int arrayOffset = copyTo.arrayOffset() + copyTo.position();
            int remaining = copyTo.remaining();
            ByteBuffer order = ByteBuffer.wrap(array, arrayOffset, remaining).slice().order(ByteOrder.BIG_ENDIAN);
            Intrinsics.e(order, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
            Memory.c(Memory.b(order), destination, 0, remaining, i8);
            copyTo.position(copyTo.limit());
            return;
        }
        d(destination, i8, copyTo.remaining()).put(copyTo);
    }

    public static final ByteBuffer d(ByteBuffer byteBuffer, int i8, int i9) {
        Intrinsics.f(byteBuffer, "<this>");
        ByteBuffer duplicate = byteBuffer.duplicate();
        Intrinsics.e(duplicate, "");
        duplicate.position(i8);
        duplicate.limit(i8 + i9);
        ByteBuffer slice = duplicate.slice();
        Intrinsics.e(slice, "");
        return slice;
    }
}
