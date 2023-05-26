package io.ktor.utils.io.internal;

import io.ktor.utils.io.ByteBufferChannel;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReadSessionImpl.kt */
/* loaded from: classes5.dex */
public final class ReadSessionImpl {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBufferChannel f47437a;

    /* renamed from: b  reason: collision with root package name */
    private ChunkBuffer f47438b;

    public ReadSessionImpl(ByteBufferChannel channel) {
        Intrinsics.f(channel, "channel");
        this.f47437a = channel;
        this.f47438b = ChunkBuffer.f47400j.a();
    }
}
