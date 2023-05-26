package io.ktor.utils.io.bits;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MemoryFactoryJvm.kt */
/* loaded from: classes5.dex */
public final class DefaultAllocator implements Allocator {

    /* renamed from: a  reason: collision with root package name */
    public static final DefaultAllocator f47363a = new DefaultAllocator();

    private DefaultAllocator() {
    }

    @Override // io.ktor.utils.io.bits.Allocator
    public void a(ByteBuffer instance) {
        Intrinsics.f(instance, "instance");
    }

    @Override // io.ktor.utils.io.bits.Allocator
    public ByteBuffer b(int i8) {
        ByteBuffer allocate = ByteBuffer.allocate(i8);
        Intrinsics.e(allocate, "allocate(size)");
        return Memory.b(allocate);
    }
}
