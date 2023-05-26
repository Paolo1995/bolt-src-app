package io.ktor.utils.io;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Coroutines.kt */
/* loaded from: classes5.dex */
final class ChannelScope implements CoroutineScope, WriterScope {

    /* renamed from: f  reason: collision with root package name */
    private final ByteChannel f47343f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ CoroutineScope f47344g;

    public ChannelScope(CoroutineScope delegate, ByteChannel channel) {
        Intrinsics.f(delegate, "delegate");
        Intrinsics.f(channel, "channel");
        this.f47343f = channel;
        this.f47344g = delegate;
    }

    @Override // io.ktor.utils.io.WriterScope
    /* renamed from: a */
    public ByteChannel getChannel() {
        return this.f47343f;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext j() {
        return this.f47344g.j();
    }
}
