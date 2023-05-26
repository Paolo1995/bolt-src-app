package eu.bolt.driver.chat.service.conversation;

import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.QuickReplyEntity;
import eu.bolt.chat.chatcore.entity.TerminationInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConversationData.kt */
/* loaded from: classes5.dex */
public final class ConversationData {

    /* renamed from: a  reason: collision with root package name */
    private final List<ChatMessageEntity> f40480a;

    /* renamed from: b  reason: collision with root package name */
    private final List<QuickReplyEntity> f40481b;

    /* renamed from: c  reason: collision with root package name */
    private final TerminationInfo f40482c;

    public ConversationData(List<ChatMessageEntity> messages, List<QuickReplyEntity> quickReplies, TerminationInfo terminationInfo) {
        Intrinsics.f(messages, "messages");
        Intrinsics.f(quickReplies, "quickReplies");
        this.f40480a = messages;
        this.f40481b = quickReplies;
        this.f40482c = terminationInfo;
    }

    public final List<ChatMessageEntity> a() {
        return this.f40480a;
    }

    public final List<QuickReplyEntity> b() {
        return this.f40481b;
    }

    public final TerminationInfo c() {
        return this.f40482c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConversationData) {
            ConversationData conversationData = (ConversationData) obj;
            return Intrinsics.a(this.f40480a, conversationData.f40480a) && Intrinsics.a(this.f40481b, conversationData.f40481b) && Intrinsics.a(this.f40482c, conversationData.f40482c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f40480a.hashCode() * 31) + this.f40481b.hashCode()) * 31;
        TerminationInfo terminationInfo = this.f40482c;
        return hashCode + (terminationInfo == null ? 0 : terminationInfo.hashCode());
    }

    public String toString() {
        List<ChatMessageEntity> list = this.f40480a;
        List<QuickReplyEntity> list2 = this.f40481b;
        TerminationInfo terminationInfo = this.f40482c;
        return "ConversationData(messages=" + list + ", quickReplies=" + list2 + ", terminationInfo=" + terminationInfo + ")";
    }
}
