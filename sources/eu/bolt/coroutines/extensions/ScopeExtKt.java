package eu.bolt.coroutines.extensions;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* compiled from: ScopeExt.kt */
/* loaded from: classes5.dex */
public final class ScopeExtKt {
    public static final void a(CoroutineScope coroutineScope, String cause) {
        Intrinsics.f(coroutineScope, "<this>");
        Intrinsics.f(cause, "cause");
        JobKt.f(coroutineScope.j(), new CancellationException(cause));
    }

    public static /* synthetic */ void b(CoroutineScope coroutineScope, String str, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = "Children cancelled";
        }
        a(coroutineScope, str);
    }
}
