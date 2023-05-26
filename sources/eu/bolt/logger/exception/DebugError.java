package eu.bolt.logger.exception;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DebugError.kt */
/* loaded from: classes5.dex */
public final class DebugError extends LinkageError {
    public DebugError() {
        this(null, null, 3, null);
    }

    public /* synthetic */ DebugError(String str, Throwable th, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? null : str, (i8 & 2) != 0 ? null : th);
    }

    public DebugError(String str, Throwable th) {
        super(str, th);
    }
}
