package eu.bolt.driver.chat.service.conversation;

import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.QuickReplyEntity;
import eu.bolt.chat.chatcore.entity.TerminationInfo;
import eu.bolt.driver.core.util.Optional;
import java.util.List;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationManager.kt */
/* loaded from: classes5.dex */
public /* synthetic */ class ConversationManager$observeConversation$1 extends FunctionReferenceImpl implements Function3<List<? extends ChatMessageEntity>, List<? extends QuickReplyEntity>, Optional<TerminationInfo>, ConversationData> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ConversationManager$observeConversation$1(Object obj) {
        super(3, obj, ConversationManager.class, "build", "build(Ljava/util/List;Ljava/util/List;Leu/bolt/driver/core/util/Optional;)Leu/bolt/driver/chat/service/conversation/ConversationData;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: j */
    public final ConversationData l(List<ChatMessageEntity> p02, List<QuickReplyEntity> p12, Optional<TerminationInfo> p22) {
        ConversationData e8;
        Intrinsics.f(p02, "p0");
        Intrinsics.f(p12, "p1");
        Intrinsics.f(p22, "p2");
        e8 = ((ConversationManager) this.f50989g).e(p02, p12, p22);
        return e8;
    }
}
