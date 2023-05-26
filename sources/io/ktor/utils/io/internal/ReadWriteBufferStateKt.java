package io.ktor.utils.io.internal;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReadWriteBufferState.kt */
/* loaded from: classes5.dex */
public final class ReadWriteBufferStateKt {

    /* renamed from: a  reason: collision with root package name */
    private static final ByteBuffer f47453a;

    /* renamed from: b  reason: collision with root package name */
    private static final RingBufferCapacity f47454b;

    static {
        ByteBuffer allocate = ByteBuffer.allocate(0);
        Intrinsics.e(allocate, "allocate(0)");
        f47453a = allocate;
        f47454b = new RingBufferCapacity(0);
    }

    public static final ByteBuffer a() {
        return f47453a;
    }

    public static final RingBufferCapacity b() {
        return f47454b;
    }
}
