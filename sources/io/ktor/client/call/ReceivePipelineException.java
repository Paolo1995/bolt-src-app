package io.ktor.client.call;

/* compiled from: HttpClientCall.kt */
/* loaded from: classes5.dex */
public final class ReceivePipelineException extends IllegalStateException {

    /* renamed from: f  reason: collision with root package name */
    private final Throwable f46084f;

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f46084f;
    }
}
