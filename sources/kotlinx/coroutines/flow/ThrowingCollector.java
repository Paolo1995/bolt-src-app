package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: Emitters.kt */
/* loaded from: classes5.dex */
public final class ThrowingCollector implements FlowCollector<Object> {

    /* renamed from: f  reason: collision with root package name */
    public final Throwable f51660f;

    public ThrowingCollector(Throwable th) {
        this.f51660f = th;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object b(Object obj, Continuation<? super Unit> continuation) {
        throw this.f51660f;
    }
}
