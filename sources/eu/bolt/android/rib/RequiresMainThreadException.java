package eu.bolt.android.rib;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequiresMainThreadException.kt */
/* loaded from: classes5.dex */
public final class RequiresMainThreadException extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequiresMainThreadException(String errorMessage, IllegalStateException exception) {
        super(errorMessage, exception);
        Intrinsics.f(errorMessage, "errorMessage");
        Intrinsics.f(exception, "exception");
    }
}
