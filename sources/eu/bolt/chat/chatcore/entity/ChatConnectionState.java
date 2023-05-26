package eu.bolt.chat.chatcore.entity;

/* compiled from: ChatConnectionState.kt */
/* loaded from: classes5.dex */
public enum ChatConnectionState {
    CONNECTING("Connecting"),
    CONNECTED("Connected"),
    DISCONNECTED("Disconnected"),
    RECONNECTING("Reconnecting");
    

    /* renamed from: f  reason: collision with root package name */
    private final String f38134f;

    ChatConnectionState(String str) {
        this.f38134f = str;
    }

    public final String c() {
        return this.f38134f;
    }

    public final boolean e() {
        if (this != CONNECTED && this != CONNECTING && this != RECONNECTING) {
            return false;
        }
        return true;
    }

    public final boolean f() {
        if (this != DISCONNECTED && this != CONNECTING) {
            return false;
        }
        return true;
    }
}
