package eu.bolt.coroutines.base;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import eu.bolt.logger.Logger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: LifecycleBoundScope.kt */
/* loaded from: classes5.dex */
public final class LifecycleBoundScopeKt {
    public static final CoroutineScope a(Lifecycle lifecycle, String tag, Logger logger) {
        Intrinsics.f(lifecycle, "lifecycle");
        Intrinsics.f(tag, "tag");
        Intrinsics.f(logger, "logger");
        return CoroutineScopeKt.g(LifecycleKt.a(lifecycle), DefaultCoroutineExceptionHandlerKt.a(tag, logger));
    }
}
