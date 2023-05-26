package eu.bolt.chat.chatcore.entity;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMessageSeenConfirmationEntity.kt */
/* loaded from: classes5.dex */
public final class ChatMessageSeenConfirmationEntity {

    /* renamed from: a  reason: collision with root package name */
    private final String f38159a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38160b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f38161c;

    public ChatMessageSeenConfirmationEntity(String id, String chatId, List<String> messageIds) {
        Intrinsics.f(id, "id");
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(messageIds, "messageIds");
        this.f38159a = id;
        this.f38160b = chatId;
        this.f38161c = messageIds;
    }

    public final String a() {
        return this.f38160b;
    }

    public final String b() {
        return this.f38159a;
    }

    public final List<String> c() {
        return this.f38161c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatMessageSeenConfirmationEntity) {
            ChatMessageSeenConfirmationEntity chatMessageSeenConfirmationEntity = (ChatMessageSeenConfirmationEntity) obj;
            return Intrinsics.a(this.f38159a, chatMessageSeenConfirmationEntity.f38159a) && Intrinsics.a(this.f38160b, chatMessageSeenConfirmationEntity.f38160b) && Intrinsics.a(this.f38161c, chatMessageSeenConfirmationEntity.f38161c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f38159a.hashCode() * 31) + this.f38160b.hashCode()) * 31) + this.f38161c.hashCode();
    }

    public String toString() {
        return "ChatMessageSeenConfirmationEntity(id=" + this.f38159a + ", chatId=" + this.f38160b + ", messageIds=" + this.f38161c + ')';
    }
}
