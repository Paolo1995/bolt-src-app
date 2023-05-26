package io.ktor.utils.io.internal;

import io.ktor.utils.io.ByteBufferChannel;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.Job;

/* compiled from: ByteBufferChannelInternals.kt */
/* loaded from: classes5.dex */
public final class JoiningState {

    /* renamed from: c  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f47428c = AtomicReferenceFieldUpdater.newUpdater(JoiningState.class, Object.class, "_closeWaitJob");
    private volatile /* synthetic */ Object _closeWaitJob;

    /* renamed from: a  reason: collision with root package name */
    private final ByteBufferChannel f47429a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f47430b;
    private volatile /* synthetic */ int closed;

    public final void a() {
        this.closed = 1;
        Job job = (Job) f47428c.getAndSet(this, null);
        if (job != null) {
            Job.DefaultImpls.a(job, null, 1, null);
        }
    }

    public final boolean b() {
        return this.f47430b;
    }

    public final ByteBufferChannel c() {
        return this.f47429a;
    }
}
