package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.ScopeCoroutine;

/* compiled from: Timeout.kt */
/* loaded from: classes5.dex */
final class TimeoutCoroutine<U, T extends U> extends ScopeCoroutine<T> implements Runnable {

    /* renamed from: i  reason: collision with root package name */
    public final long f51339i;

    public TimeoutCoroutine(long j8, Continuation<? super U> continuation) {
        super(continuation.getContext(), continuation);
        this.f51339i = j8;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine, kotlinx.coroutines.JobSupport
    public String H0() {
        return super.H0() + "(timeMillis=" + this.f51339i + ')';
    }

    @Override // java.lang.Runnable
    public void run() {
        R(TimeoutKt.a(this.f51339i, this));
    }
}
