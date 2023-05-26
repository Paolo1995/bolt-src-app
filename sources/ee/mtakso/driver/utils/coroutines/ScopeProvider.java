package ee.mtakso.driver.utils.coroutines;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: ScopeProvider.kt */
/* loaded from: classes5.dex */
public final class ScopeProvider {
    public final CoroutineScope a(CoroutineDispatcher dispatcher) {
        Intrinsics.f(dispatcher, "dispatcher");
        return CoroutineScopeKt.a(dispatcher);
    }
}
