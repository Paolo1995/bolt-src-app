package eu.bolt.chat.storage;

import eu.bolt.chat.network.data.MqttMessage;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PendingRawMessageStorage.kt */
/* loaded from: classes5.dex */
public final class PendingRawMessage {

    /* renamed from: a  reason: collision with root package name */
    private final String f39641a;

    /* renamed from: b  reason: collision with root package name */
    private final MqttMessage f39642b;

    public PendingRawMessage(String messageId, MqttMessage message) {
        Intrinsics.f(messageId, "messageId");
        Intrinsics.f(message, "message");
        this.f39641a = messageId;
        this.f39642b = message;
    }

    public final MqttMessage a() {
        return this.f39642b;
    }

    public final String b() {
        return this.f39641a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PendingRawMessage) {
            PendingRawMessage pendingRawMessage = (PendingRawMessage) obj;
            return Intrinsics.a(this.f39641a, pendingRawMessage.f39641a) && Intrinsics.a(this.f39642b, pendingRawMessage.f39642b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f39641a.hashCode() * 31) + this.f39642b.hashCode();
    }

    public String toString() {
        return "PendingRawMessage(messageId=" + this.f39641a + ", message=" + this.f39642b + ')';
    }
}
