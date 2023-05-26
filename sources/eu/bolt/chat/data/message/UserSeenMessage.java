package eu.bolt.chat.data.message;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserSeenMessage.kt */
/* loaded from: classes5.dex */
public final class UserSeenMessage implements IdentifiableChatMessage {

    /* renamed from: a  reason: collision with root package name */
    private final String f39020a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39021b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f39022c;

    public UserSeenMessage(String id, String chatId, List<String> seenMessageIds) {
        Intrinsics.f(id, "id");
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(seenMessageIds, "seenMessageIds");
        this.f39020a = id;
        this.f39021b = chatId;
        this.f39022c = seenMessageIds;
    }

    @Override // eu.bolt.chat.data.message.IdentifiableChatMessage
    public String d() {
        return this.f39021b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UserSeenMessage) {
            UserSeenMessage userSeenMessage = (UserSeenMessage) obj;
            return Intrinsics.a(getId(), userSeenMessage.getId()) && Intrinsics.a(d(), userSeenMessage.d()) && Intrinsics.a(this.f39022c, userSeenMessage.f39022c);
        }
        return false;
    }

    public final List<String> g() {
        return this.f39022c;
    }

    @Override // eu.bolt.chat.data.message.IdentifiableChatMessage
    public String getId() {
        return this.f39020a;
    }

    public int hashCode() {
        return (((getId().hashCode() * 31) + d().hashCode()) * 31) + this.f39022c.hashCode();
    }

    public String toString() {
        return "UserSeenMessage(id=" + getId() + ", chatId=" + d() + ", seenMessageIds=" + this.f39022c + ')';
    }
}
