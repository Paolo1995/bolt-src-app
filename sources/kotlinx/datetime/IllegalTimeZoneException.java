package kotlinx.datetime;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Exceptions.kt */
/* loaded from: classes5.dex */
public final class IllegalTimeZoneException extends IllegalArgumentException {
    public IllegalTimeZoneException() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IllegalTimeZoneException(Throwable cause) {
        super(cause);
        Intrinsics.f(cause, "cause");
    }
}
