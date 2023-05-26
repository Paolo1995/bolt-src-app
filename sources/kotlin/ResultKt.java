package kotlin;

import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Result.kt */
/* loaded from: classes5.dex */
public final class ResultKt {
    public static final Object a(Throwable exception) {
        Intrinsics.f(exception, "exception");
        return new Result.Failure(exception);
    }

    public static final void b(Object obj) {
        if (!(obj instanceof Result.Failure)) {
            return;
        }
        throw ((Result.Failure) obj).f50820f;
    }
}
