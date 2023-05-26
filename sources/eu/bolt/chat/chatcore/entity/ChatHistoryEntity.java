package eu.bolt.chat.chatcore.entity;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatHistoryEntity.kt */
/* loaded from: classes5.dex */
public final class ChatHistoryEntity {

    /* renamed from: a  reason: collision with root package name */
    private final ChatEntity f38141a;

    /* renamed from: b  reason: collision with root package name */
    private final List<ChatMessageEntity> f38142b;

    /* renamed from: c  reason: collision with root package name */
    private final TerminationInfo f38143c;

    public ChatHistoryEntity(ChatEntity chatEntity, List<ChatMessageEntity> messages, TerminationInfo terminationInfo) {
        Intrinsics.f(chatEntity, "chatEntity");
        Intrinsics.f(messages, "messages");
        this.f38141a = chatEntity;
        this.f38142b = messages;
        this.f38143c = terminationInfo;
    }

    public final ChatEntity a() {
        return this.f38141a;
    }

    public final List<ChatMessageEntity> b() {
        return this.f38142b;
    }

    public final TerminationInfo c() {
        return this.f38143c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatHistoryEntity) {
            ChatHistoryEntity chatHistoryEntity = (ChatHistoryEntity) obj;
            return Intrinsics.a(this.f38141a, chatHistoryEntity.f38141a) && Intrinsics.a(this.f38142b, chatHistoryEntity.f38142b) && Intrinsics.a(this.f38143c, chatHistoryEntity.f38143c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f38141a.hashCode() * 31) + this.f38142b.hashCode()) * 31;
        TerminationInfo terminationInfo = this.f38143c;
        return hashCode + (terminationInfo == null ? 0 : terminationInfo.hashCode());
    }

    public String toString() {
        return "ChatHistoryEntity(chatEntity=" + this.f38141a + ", messages=" + this.f38142b + ", terminationInfo=" + this.f38143c + ')';
    }
}
