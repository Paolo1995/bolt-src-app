package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* compiled from: CoroutineScope.kt */
/* loaded from: classes5.dex */
public final class GlobalScope implements CoroutineScope {

    /* renamed from: f  reason: collision with root package name */
    public static final GlobalScope f51286f = new GlobalScope();

    private GlobalScope() {
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext j() {
        return EmptyCoroutineContext.f50912f;
    }
}
