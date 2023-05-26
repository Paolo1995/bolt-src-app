package io.ktor.client.network.sockets;

import java.net.ConnectException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimeoutExceptions.kt */
/* loaded from: classes5.dex */
public final class ConnectTimeoutException extends ConnectException {

    /* renamed from: f  reason: collision with root package name */
    private final Throwable f46228f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectTimeoutException(String message, Throwable th) {
        super(message);
        Intrinsics.f(message, "message");
        this.f46228f = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f46228f;
    }
}
