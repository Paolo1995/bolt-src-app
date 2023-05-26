package eu.bolt.chat.chatcore.network.repo;

import eu.bolt.chat.chatcore.network.model.ChatEventRequest;
import eu.bolt.chat.chatcore.network.model.ChatRequest;
import eu.bolt.chat.chatcore.network.model.ChatResponse;
import eu.bolt.chat.chatcore.network.model.ClientContext;
import eu.bolt.chat.chatcore.network.model.MqttEventRequest;
import eu.bolt.chat.chatcore.network.model.MqttEventResponse;
import eu.bolt.chat.chatcore.user.MqttMessageExtrasProvider;
import eu.bolt.chat.tools.uniqueid.IdGenerator;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MqttEventMapper.kt */
/* loaded from: classes5.dex */
public final class MqttEventMapper {

    /* renamed from: a  reason: collision with root package name */
    private final MqttMessageExtrasProvider f38372a;

    /* renamed from: b  reason: collision with root package name */
    private final IdGenerator f38373b;

    @Inject
    public MqttEventMapper(MqttMessageExtrasProvider userMqttMessageExtrasProvider, IdGenerator idGenerator) {
        Intrinsics.f(userMqttMessageExtrasProvider, "userMqttMessageExtrasProvider");
        Intrinsics.f(idGenerator, "idGenerator");
        this.f38372a = userMqttMessageExtrasProvider;
        this.f38373b = idGenerator;
    }

    public final boolean a(MqttEventResponse mqttEvent) {
        Intrinsics.f(mqttEvent, "mqttEvent");
        return mqttEvent instanceof MqttEventResponse.Chat;
    }

    public final MqttEventRequest.Chat b(String chatId, ChatEventRequest event) {
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(event, "event");
        return new MqttEventRequest.Chat(this.f38373b.a(), new ClientContext(this.f38372a.a(), this.f38372a.b()), new ChatRequest(chatId, event));
    }

    public final ChatResponse c(MqttEventResponse mqttEvent) {
        Intrinsics.f(mqttEvent, "mqttEvent");
        return ((MqttEventResponse.Chat) mqttEvent).a();
    }
}
