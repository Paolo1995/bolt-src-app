package eu.bolt.chat.chatcore.network.repo;

import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageSeenConfirmationEntity;
import eu.bolt.chat.chatcore.entity.ChatRequestReplySuggestionsEntity;
import eu.bolt.chat.chatcore.network.model.ChatEventRequest;
import eu.bolt.chat.chatcore.network.model.ChatEventResponse;
import eu.bolt.chat.chatcore.network.model.ChatResponse;
import eu.bolt.chat.chatcore.network.model.MqttEventRequest;
import eu.bolt.chat.chatcore.network.model.MqttEventResponse;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MqttChatEventMapper.kt */
/* loaded from: classes5.dex */
public final class MqttChatEventMapper {

    /* renamed from: a  reason: collision with root package name */
    private final ChatEventMapper f38368a;

    /* renamed from: b  reason: collision with root package name */
    private final MqttEventMapper f38369b;

    @Inject
    public MqttChatEventMapper(ChatEventMapper chatEventMapper, MqttEventMapper mqttEventMapper) {
        Intrinsics.f(chatEventMapper, "chatEventMapper");
        Intrinsics.f(mqttEventMapper, "mqttEventMapper");
        this.f38368a = chatEventMapper;
        this.f38369b = mqttEventMapper;
    }

    public final MqttEventRequest.Chat a(ChatRequestReplySuggestionsEntity entity) {
        Intrinsics.f(entity, "entity");
        return this.f38369b.b(entity.a(), new ChatEventRequest.RequestReplySuggestions(entity.b()));
    }

    public final boolean b(MqttEventResponse mqttEvent) {
        Intrinsics.f(mqttEvent, "mqttEvent");
        return this.f38369b.a(mqttEvent);
    }

    public final ChatEvent c(MqttEventResponse mqttEvent) {
        Intrinsics.f(mqttEvent, "mqttEvent");
        ChatResponse c8 = this.f38369b.c(mqttEvent);
        ChatEventResponse b8 = c8.b();
        if (b8 instanceof ChatEventResponse.QuickReplies) {
            return this.f38368a.i((ChatEventResponse.QuickReplies) b8);
        }
        if (b8 instanceof ChatEventResponse.MessagesSeenConfirmation) {
            return this.f38368a.e((ChatEventResponse.MessagesSeenConfirmation) b8);
        }
        if (b8 instanceof ChatEventResponse.NewMessage) {
            return this.f38368a.g(c8.a(), (ChatEventResponse.NewMessage) b8);
        }
        if (b8 instanceof ChatEventResponse.TerminalEvent) {
            return this.f38368a.l(c8.a(), (ChatEventResponse.TerminalEvent) b8);
        }
        if (b8 instanceof ChatEventResponse.StartEvent) {
            return this.f38368a.k(c8.a(), (ChatEventResponse.StartEvent) b8);
        }
        if (b8 instanceof ChatEventResponse.ServiceMessageEvent) {
            return this.f38368a.j(c8.a(), (ChatEventResponse.ServiceMessageEvent) b8);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final MqttEventRequest.Chat d(ChatMessageSeenConfirmationEntity entity) {
        Intrinsics.f(entity, "entity");
        return this.f38369b.b(entity.a(), new ChatEventRequest.MessagesSeen(entity.b(), entity.c()));
    }

    public final MqttEventRequest.Chat e(ChatMessageEntity messageEntity) {
        Intrinsics.f(messageEntity, "messageEntity");
        return this.f38369b.b(messageEntity.b(), this.f38368a.f(messageEntity));
    }
}
