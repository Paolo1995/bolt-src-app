package eu.bolt.chat.network.exception;

import eu.bolt.chat.network.data.ConnAckReturnCode;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConnectionAckException.kt */
/* loaded from: classes5.dex */
public final class ConnectionAckException extends ConnectionException {

    /* renamed from: f  reason: collision with root package name */
    private final ConnAckReturnCode f39533f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectionAckException(ConnAckReturnCode returnCode, String str, Throwable th) {
        super(str, th);
        Intrinsics.f(returnCode, "returnCode");
        this.f39533f = returnCode;
    }

    public final ConnAckReturnCode a() {
        return this.f39533f;
    }
}
