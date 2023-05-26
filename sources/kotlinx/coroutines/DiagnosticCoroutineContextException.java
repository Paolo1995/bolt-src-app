package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* compiled from: CoroutineExceptionHandlerImpl.kt */
/* loaded from: classes5.dex */
final class DiagnosticCoroutineContextException extends RuntimeException {

    /* renamed from: f  reason: collision with root package name */
    private final CoroutineContext f51258f;

    public DiagnosticCoroutineContextException(CoroutineContext coroutineContext) {
        this.f51258f = coroutineContext;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.f51258f.toString();
    }
}
