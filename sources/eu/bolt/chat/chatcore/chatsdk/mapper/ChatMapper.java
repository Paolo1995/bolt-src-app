package eu.bolt.chat.chatcore.chatsdk.mapper;

import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.chat.data.Chat;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMapper.kt */
/* loaded from: classes5.dex */
public final class ChatMapper {

    /* renamed from: a  reason: collision with root package name */
    private final OrderMapper f38063a;

    public ChatMapper(OrderMapper orderMapper) {
        Intrinsics.f(orderMapper, "orderMapper");
        this.f38063a = orderMapper;
    }

    public final ChatEntity a(Chat chat) {
        Intrinsics.f(chat, "chat");
        return new ChatEntity(chat.d(), chat.g(), chat.h(), chat.c(), 0L, this.f38063a.b(chat.e()));
    }
}
