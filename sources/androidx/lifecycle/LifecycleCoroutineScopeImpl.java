package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt__JobKt;

/* compiled from: Lifecycle.kt */
/* loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements LifecycleEventObserver {

    /* renamed from: f  reason: collision with root package name */
    private final Lifecycle f6674f;

    /* renamed from: g  reason: collision with root package name */
    private final CoroutineContext f6675g;

    public LifecycleCoroutineScopeImpl(Lifecycle lifecycle, CoroutineContext coroutineContext) {
        Intrinsics.f(lifecycle, "lifecycle");
        Intrinsics.f(coroutineContext, "coroutineContext");
        this.f6674f = lifecycle;
        this.f6675g = coroutineContext;
        if (b().b() == Lifecycle.State.DESTROYED) {
            JobKt__JobKt.e(j(), null, 1, null);
        }
    }

    public Lifecycle b() {
        return this.f6674f;
    }

    public final void c() {
        BuildersKt__Builders_commonKt.d(this, Dispatchers.c().R0(), null, new LifecycleCoroutineScopeImpl$register$1(this, null), 2, null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext j() {
        return this.f6675g;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.f(source, "source");
        Intrinsics.f(event, "event");
        if (b().b().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            b().c(this);
            JobKt__JobKt.e(j(), null, 1, null);
        }
    }
}
