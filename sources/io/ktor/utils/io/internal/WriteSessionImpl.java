package io.ktor.utils.io.internal;

import io.ktor.utils.io.ByteBufferChannel;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WriteSessionImpl.kt */
/* loaded from: classes5.dex */
public final class WriteSessionImpl {

    /* renamed from: a  reason: collision with root package name */
    private ByteBufferChannel f47471a;

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f47472b;

    /* renamed from: c  reason: collision with root package name */
    private ChunkBuffer f47473c;

    /* renamed from: d  reason: collision with root package name */
    private RingBufferCapacity f47474d;

    public WriteSessionImpl(ByteBufferChannel channel) {
        Intrinsics.f(channel, "channel");
        this.f47471a = channel.r0();
        ChunkBuffer.Companion companion = ChunkBuffer.f47400j;
        this.f47472b = companion.a().h();
        this.f47473c = companion.a();
        this.f47474d = this.f47471a.Q().f47440b;
    }
}
