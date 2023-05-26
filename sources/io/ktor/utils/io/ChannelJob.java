package io.ktor.utils.io;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.ChildJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Coroutines.kt */
/* loaded from: classes5.dex */
public final class ChannelJob implements Job, WriterJob {

    /* renamed from: f  reason: collision with root package name */
    private final Job f47341f;

    /* renamed from: g  reason: collision with root package name */
    private final ByteChannel f47342g;

    public ChannelJob(Job delegate, ByteChannel channel) {
        Intrinsics.f(delegate, "delegate");
        Intrinsics.f(channel, "channel");
        this.f47341f = delegate;
        this.f47342g = channel;
    }

    @Override // kotlinx.coroutines.Job
    public ChildHandle D0(ChildJob child) {
        Intrinsics.f(child, "child");
        return this.f47341f.D0(child);
    }

    @Override // kotlinx.coroutines.Job
    public DisposableHandle F(boolean z7, boolean z8, Function1<? super Throwable, Unit> handler) {
        Intrinsics.f(handler, "handler");
        return this.f47341f.F(z7, z8, handler);
    }

    @Override // kotlinx.coroutines.Job
    public CancellationException I() {
        return this.f47341f.I();
    }

    @Override // kotlinx.coroutines.Job
    public DisposableHandle X(Function1<? super Throwable, Unit> handler) {
        Intrinsics.f(handler, "handler");
        return this.f47341f.X(handler);
    }

    @Override // io.ktor.utils.io.WriterJob
    /* renamed from: b */
    public ByteChannel getChannel() {
        return this.f47342g;
    }

    @Override // kotlinx.coroutines.Job
    public void e(CancellationException cancellationException) {
        this.f47341f.e(cancellationException);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E g(CoroutineContext.Key<E> key) {
        Intrinsics.f(key, "key");
        return (E) this.f47341f.g(key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public CoroutineContext.Key<?> getKey() {
        return this.f47341f.getKey();
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext h(CoroutineContext.Key<?> key) {
        Intrinsics.f(key, "key");
        return this.f47341f.h(key);
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        return this.f47341f.isActive();
    }

    @Override // kotlinx.coroutines.Job
    public boolean isCancelled() {
        return this.f47341f.isCancelled();
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R l(R r7, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        Intrinsics.f(operation, "operation");
        return (R) this.f47341f.l(r7, operation);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext s0(CoroutineContext context) {
        Intrinsics.f(context, "context");
        return this.f47341f.s0(context);
    }

    @Override // kotlinx.coroutines.Job
    public boolean start() {
        return this.f47341f.start();
    }

    public String toString() {
        return "ChannelJob[" + this.f47341f + ']';
    }

    @Override // kotlinx.coroutines.Job
    public Object v0(Continuation<? super Unit> continuation) {
        return this.f47341f.v0(continuation);
    }

    @Override // kotlinx.coroutines.Job
    public Sequence<Job> y() {
        return this.f47341f.y();
    }
}
