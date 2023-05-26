package io.ktor.client.call;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpClientCall.kt */
/* loaded from: classes5.dex */
public final class DoubleReceiveException extends IllegalStateException {

    /* renamed from: f  reason: collision with root package name */
    private final String f46069f;

    public DoubleReceiveException(HttpClientCall call) {
        Intrinsics.f(call, "call");
        this.f46069f = "Response already received: " + call;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f46069f;
    }
}
