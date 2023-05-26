package eu.bolt.chat.network.exception;

/* compiled from: DisconnectException.kt */
/* loaded from: classes5.dex */
public final class DisconnectException extends ConnectionException {
    public DisconnectException() {
    }

    public DisconnectException(String str) {
        super(str);
    }

    public DisconnectException(String str, Throwable th) {
        super(str, th);
    }
}
