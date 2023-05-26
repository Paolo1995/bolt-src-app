package eu.bolt.chat.chatcore.network.error;

/* compiled from: ClientNotConnectedException.kt */
/* loaded from: classes5.dex */
public final class ClientNotConnectedException extends RuntimeException {
    public ClientNotConnectedException() {
        super("Mqtt Client should be connected");
    }
}
