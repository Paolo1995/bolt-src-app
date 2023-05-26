package eu.bolt.chat.chatcore.entity;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: NewChatMessageEntity.kt */
/* loaded from: classes5.dex */
public final class NewChatMessageEntity {

    /* renamed from: a  reason: collision with root package name */
    private final ChatMessageEntity f38175a;

    /* renamed from: b  reason: collision with root package name */
    private final ChatEntity f38176b;

    public NewChatMessageEntity(ChatMessageEntity messageEntity, ChatEntity chatEntity) {
        Intrinsics.f(messageEntity, "messageEntity");
        Intrinsics.f(chatEntity, "chatEntity");
        this.f38175a = messageEntity;
        this.f38176b = chatEntity;
    }

    public final ChatEntity a() {
        return this.f38176b;
    }

    public final ChatMessageEntity b() {
        return this.f38175a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NewChatMessageEntity) {
            NewChatMessageEntity newChatMessageEntity = (NewChatMessageEntity) obj;
            return Intrinsics.a(this.f38175a, newChatMessageEntity.f38175a) && Intrinsics.a(this.f38176b, newChatMessageEntity.f38176b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f38175a.hashCode() * 31) + this.f38176b.hashCode();
    }

    public String toString() {
        return "NewChatMessageEntity(messageEntity=" + this.f38175a + ", chatEntity=" + this.f38176b + ')';
    }
}
