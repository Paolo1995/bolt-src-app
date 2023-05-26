package eu.bolt.chat.network.exception;

/* compiled from: ConnectionException.kt */
/* loaded from: classes5.dex */
public abstract class ConnectionException extends MqttException {
    public ConnectionException() {
    }

    public ConnectionException(String str) {
        super(str);
    }

    public ConnectionException(String str, Throwable th) {
        super(str, th);
    }
}
