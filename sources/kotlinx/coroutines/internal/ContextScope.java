package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Scopes.kt */
/* loaded from: classes5.dex */
public final class ContextScope implements CoroutineScope {

    /* renamed from: f  reason: collision with root package name */
    private final CoroutineContext f51781f;

    public ContextScope(CoroutineContext coroutineContext) {
        this.f51781f = coroutineContext;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext j() {
        return this.f51781f;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + j() + ')';
    }
}
