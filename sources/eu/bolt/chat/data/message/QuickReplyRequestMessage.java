package eu.bolt.chat.data.message;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuickReplyRequestMessage.kt */
/* loaded from: classes5.dex */
public final class QuickReplyRequestMessage implements IdentifiableChatMessage {

    /* renamed from: a  reason: collision with root package name */
    private final String f39009a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39010b;

    public QuickReplyRequestMessage(String id, String chatId) {
        Intrinsics.f(id, "id");
        Intrinsics.f(chatId, "chatId");
        this.f39009a = id;
        this.f39010b = chatId;
    }

    @Override // eu.bolt.chat.data.message.IdentifiableChatMessage
    public String d() {
        return this.f39010b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof QuickReplyRequestMessage) {
            QuickReplyRequestMessage quickReplyRequestMessage = (QuickReplyRequestMessage) obj;
            return Intrinsics.a(getId(), quickReplyRequestMessage.getId()) && Intrinsics.a(d(), quickReplyRequestMessage.d());
        }
        return false;
    }

    @Override // eu.bolt.chat.data.message.IdentifiableChatMessage
    public String getId() {
        return this.f39009a;
    }

    public int hashCode() {
        return (getId().hashCode() * 31) + d().hashCode();
    }

    public String toString() {
        return "QuickReplyRequestMessage(id=" + getId() + ", chatId=" + d() + ')';
    }
}
