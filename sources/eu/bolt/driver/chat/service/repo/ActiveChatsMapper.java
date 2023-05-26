package eu.bolt.driver.chat.service.repo;

import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.driver.chat.network.ActiveChat;
import eu.bolt.driver.chat.network.ActiveChats;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActiveChatsMapper.kt */
/* loaded from: classes5.dex */
public final class ActiveChatsMapper {
    private final ChatEntity b(ActiveChat activeChat) {
        return new ChatEntity(activeChat.a(), activeChat.e(), activeChat.f(), activeChat.b(), activeChat.d(), UtilKt.a(activeChat.c()));
    }

    public final List<ChatEntity> a(ActiveChats activeChatResponse) {
        List<ChatEntity> k8;
        int v7;
        Intrinsics.f(activeChatResponse, "activeChatResponse");
        List<ActiveChat> a8 = activeChatResponse.a();
        if (a8 != null) {
            v7 = CollectionsKt__IterablesKt.v(a8, 10);
            ArrayList arrayList = new ArrayList(v7);
            for (ActiveChat activeChat : a8) {
                arrayList.add(b(activeChat));
            }
            return arrayList;
        }
        k8 = CollectionsKt__CollectionsKt.k();
        return k8;
    }
}
