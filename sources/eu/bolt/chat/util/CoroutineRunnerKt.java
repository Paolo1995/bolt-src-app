package eu.bolt.chat.util;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CoroutineRunner.kt */
/* loaded from: classes5.dex */
public final class CoroutineRunnerKt {
    public static final CoroutineRunner a(CoroutineScope scope) {
        Intrinsics.f(scope, "scope");
        return new StableCoroutineRunner(scope);
    }
}
