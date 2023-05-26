package eu.bolt.chat.network.exception;

/* compiled from: MqttException.kt */
/* loaded from: classes5.dex */
public abstract class MqttException extends Exception {
    public MqttException() {
    }

    public MqttException(String str) {
        super(str);
    }

    public MqttException(String str, Throwable th) {
        super(str, th);
    }
}
