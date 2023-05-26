package eu.bolt.chat.data.message;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuickReplyMessage.kt */
/* loaded from: classes5.dex */
public final class QuickReplyMessage implements IdentifiableChatMessage {

    /* renamed from: a  reason: collision with root package name */
    private final String f39006a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39007b;

    /* renamed from: c  reason: collision with root package name */
    private final String f39008c;

    public QuickReplyMessage(String id, String chatId, String quickReplySuggestionId) {
        Intrinsics.f(id, "id");
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(quickReplySuggestionId, "quickReplySuggestionId");
        this.f39006a = id;
        this.f39007b = chatId;
        this.f39008c = quickReplySuggestionId;
    }

    @Override // eu.bolt.chat.data.message.IdentifiableChatMessage
    public String d() {
        return this.f39007b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof QuickReplyMessage) {
            QuickReplyMessage quickReplyMessage = (QuickReplyMessage) obj;
            return Intrinsics.a(getId(), quickReplyMessage.getId()) && Intrinsics.a(d(), quickReplyMessage.d()) && Intrinsics.a(this.f39008c, quickReplyMessage.f39008c);
        }
        return false;
    }

    public final String g() {
        return this.f39008c;
    }

    @Override // eu.bolt.chat.data.message.IdentifiableChatMessage
    public String getId() {
        return this.f39006a;
    }

    public int hashCode() {
        return (((getId().hashCode() * 31) + d().hashCode()) * 31) + this.f39008c.hashCode();
    }

    public String toString() {
        return "QuickReplyMessage(id=" + getId() + ", chatId=" + d() + ", quickReplySuggestionId=" + this.f39008c + ')';
    }
}
