package eu.bolt.driver.chat.ui.screen.conversation.pager;

import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.driver.chat.ui.screen.conversation.pager.item.Conversation;
import eu.bolt.driver.chat.ui.screen.conversation.pager.item.OrderHandleUi;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConversationMapper.kt */
/* loaded from: classes5.dex */
public final class ConversationMapper {
    private final OrderHandleUi b(ChatEntity chatEntity) {
        String c8 = chatEntity.c().c();
        Long a8 = chatEntity.c().a();
        if (c8 != null && a8 != null) {
            return new OrderHandleUi(chatEntity.c().b(), c8, a8.longValue());
        }
        return null;
    }

    public final List<Conversation> a(List<ChatEntity> chatEntities) {
        int v7;
        Intrinsics.f(chatEntities, "chatEntities");
        v7 = CollectionsKt__IterablesKt.v(chatEntities, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (ChatEntity chatEntity : chatEntities) {
            arrayList.add(new Conversation(chatEntity.b(), chatEntity.f(), chatEntity.a(), b(chatEntity)));
        }
        return arrayList;
    }
}
