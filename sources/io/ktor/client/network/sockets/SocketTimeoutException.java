package io.ktor.client.network.sockets;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimeoutExceptions.kt */
/* loaded from: classes5.dex */
public final class SocketTimeoutException extends java.net.SocketTimeoutException {

    /* renamed from: f  reason: collision with root package name */
    private final Throwable f46229f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocketTimeoutException(String message, Throwable th) {
        super(message);
        Intrinsics.f(message, "message");
        this.f46229f = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f46229f;
    }
}
