package eu.bolt.chat.chatcore.entity;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatRequestReplySuggestionsEntity.kt */
/* loaded from: classes5.dex */
public final class ChatRequestReplySuggestionsEntity {

    /* renamed from: a  reason: collision with root package name */
    private final String f38173a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38174b;

    public ChatRequestReplySuggestionsEntity(String id, String chatId) {
        Intrinsics.f(id, "id");
        Intrinsics.f(chatId, "chatId");
        this.f38173a = id;
        this.f38174b = chatId;
    }

    public final String a() {
        return this.f38174b;
    }

    public final String b() {
        return this.f38173a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatRequestReplySuggestionsEntity) {
            ChatRequestReplySuggestionsEntity chatRequestReplySuggestionsEntity = (ChatRequestReplySuggestionsEntity) obj;
            return Intrinsics.a(this.f38173a, chatRequestReplySuggestionsEntity.f38173a) && Intrinsics.a(this.f38174b, chatRequestReplySuggestionsEntity.f38174b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f38173a.hashCode() * 31) + this.f38174b.hashCode();
    }

    public String toString() {
        return "ChatRequestReplySuggestionsEntity(id=" + this.f38173a + ", chatId=" + this.f38174b + ')';
    }
}
