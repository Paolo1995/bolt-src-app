package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: WithLifecycleState.kt */
/* loaded from: classes.dex */
public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 implements LifecycleEventObserver {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Lifecycle.State f6805f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ Lifecycle f6806g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ CancellableContinuation<Object> f6807h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ Function0<Object> f6808i;

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Object b8;
        Intrinsics.f(source, "source");
        Intrinsics.f(event, "event");
        if (event == Lifecycle.Event.f(this.f6805f)) {
            this.f6806g.c(this);
            CancellableContinuation<Object> cancellableContinuation = this.f6807h;
            Function0<Object> function0 = this.f6808i;
            try {
                Result.Companion companion = Result.f50818g;
                b8 = Result.b(function0.invoke());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.f50818g;
                b8 = Result.b(ResultKt.a(th));
            }
            cancellableContinuation.resumeWith(b8);
        } else if (event == Lifecycle.Event.ON_DESTROY) {
            this.f6806g.c(this);
            CancellableContinuation<Object> cancellableContinuation2 = this.f6807h;
            Result.Companion companion3 = Result.f50818g;
            cancellableContinuation2.resumeWith(Result.b(ResultKt.a(new LifecycleDestroyedException())));
        }
    }
}
