package eu.bolt.chat.network.data.serializer;

import eu.bolt.chat.data.message.IdentifiableChatMessage;
import eu.bolt.chat.data.message.QuickReplyMessage;
import eu.bolt.chat.data.message.QuickReplyRequestMessage;
import eu.bolt.chat.data.message.UserSeenMessage;
import eu.bolt.chat.data.message.UserTextMessage;
import eu.bolt.chat.network.data.ClientContext;
import eu.bolt.chat.network.data.OutgoingChatDomainEvent;
import eu.bolt.chat.network.data.OutgoingChatEvent;
import eu.bolt.chat.network.data.OutgoingChatMessageEvent;
import eu.bolt.chat.network.data.OutgoingEventBase;
import eu.bolt.chat.network.data.OutgoingMessageSeenEvent;
import eu.bolt.chat.network.data.OutgoingQuickReplyMessageEvent;
import eu.bolt.chat.network.data.OutgoingQuickReplyRequestEvent;
import eu.bolt.chat.network.data.parser.ChatJsonParserKt;
import eu.bolt.chat.util.UUID;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;

/* compiled from: MqttChatMessageEncoder.kt */
/* loaded from: classes5.dex */
public final class DefaultMqttChatMessageEncoder implements MqttChatMessageEncoder {

    /* renamed from: a  reason: collision with root package name */
    private final ClientContext f39338a;

    /* renamed from: b  reason: collision with root package name */
    private final Json f39339b;

    public DefaultMqttChatMessageEncoder(ClientContext clientContext) {
        Intrinsics.f(clientContext, "clientContext");
        this.f39338a = clientContext;
        this.f39339b = ChatJsonParserKt.a();
    }

    private final String e(OutgoingChatDomainEvent outgoingChatDomainEvent) {
        Json json = this.f39339b;
        KSerializer<Object> c8 = SerializersKt.c(json.a(), Reflection.i(OutgoingChatDomainEvent.class));
        Intrinsics.d(c8, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return json.d(c8, outgoingChatDomainEvent);
    }

    private final <T extends IdentifiableChatMessage> OutgoingChatDomainEvent f(T t7, OutgoingEventBase outgoingEventBase) {
        return new OutgoingChatDomainEvent(UUID.f39707a.a(), (String) null, new OutgoingChatEvent(t7.d(), outgoingEventBase), this.f39338a, 2, (DefaultConstructorMarker) null);
    }

    private final OutgoingChatDomainEvent g(UserTextMessage userTextMessage) {
        return f(userTextMessage, new OutgoingChatMessageEvent(userTextMessage.getId(), userTextMessage.j()));
    }

    private final OutgoingChatDomainEvent h(UserSeenMessage userSeenMessage) {
        return f(userSeenMessage, new OutgoingMessageSeenEvent(userSeenMessage.getId(), userSeenMessage.g()));
    }

    private final OutgoingChatDomainEvent i(QuickReplyMessage quickReplyMessage) {
        return f(quickReplyMessage, new OutgoingQuickReplyMessageEvent(quickReplyMessage.getId(), quickReplyMessage.g()));
    }

    private final OutgoingChatDomainEvent j(QuickReplyRequestMessage quickReplyRequestMessage) {
        return f(quickReplyRequestMessage, new OutgoingQuickReplyRequestEvent(quickReplyRequestMessage.getId()));
    }

    @Override // eu.bolt.chat.network.data.serializer.MqttChatMessageEncoder
    public String a(QuickReplyMessage message) {
        Intrinsics.f(message, "message");
        return e(i(message));
    }

    @Override // eu.bolt.chat.network.data.serializer.MqttChatMessageEncoder
    public String b(UserSeenMessage message) {
        Intrinsics.f(message, "message");
        return e(h(message));
    }

    @Override // eu.bolt.chat.network.data.serializer.MqttChatMessageEncoder
    public String c(UserTextMessage message) {
        Intrinsics.f(message, "message");
        return e(g(message));
    }

    @Override // eu.bolt.chat.network.data.serializer.MqttChatMessageEncoder
    public String d(QuickReplyRequestMessage message) {
        Intrinsics.f(message, "message");
        return e(j(message));
    }
}
