package eu.bolt.chat.network.data.parser;

import co.touchlab.kermit.Logger;
import co.touchlab.kermit.Severity;
import eu.bolt.chat.client.MessageBox;
import eu.bolt.chat.data.mapper.ChatMapperKt;
import eu.bolt.chat.data.mapper.MessageMapperKt;
import eu.bolt.chat.data.message.MessageEvent;
import eu.bolt.chat.data.message.UserMessage;
import eu.bolt.chat.data.message.UserTextMessage;
import eu.bolt.chat.data.util.MessageDirectionDetector;
import eu.bolt.chat.network.data.BrokerEvent;
import eu.bolt.chat.network.data.ChatMessageSender;
import eu.bolt.chat.network.data.EndChatEvent;
import eu.bolt.chat.network.data.EventBase;
import eu.bolt.chat.network.data.IncomingChatDomainEvent;
import eu.bolt.chat.network.data.MqttMessage;
import eu.bolt.chat.network.data.QuickReplySuggestionNet;
import eu.bolt.chat.network.data.QuickReplySuggestionsEvent;
import eu.bolt.chat.network.data.SeenMessagesEvent;
import eu.bolt.chat.network.data.ServiceMessageEvent;
import eu.bolt.chat.network.data.StartChatEvent;
import eu.bolt.chat.network.data.UnknownMessageEvent;
import eu.bolt.chat.network.data.UserMessageEvent;
import eu.bolt.chat.network.data.serializer.BrokerEventSerializer;
import eu.bolt.chat.util.DateTimeUtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDateTime;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.json.Json;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MqttMessageParser.kt */
/* loaded from: classes5.dex */
public final class DefaultMessageParser implements MqttMessageParser {

    /* renamed from: a  reason: collision with root package name */
    private final MessageDirectionDetector f39334a;

    /* renamed from: b  reason: collision with root package name */
    private final Logger f39335b;

    /* renamed from: c  reason: collision with root package name */
    private final Json f39336c;

    public DefaultMessageParser(MessageDirectionDetector messageDirectionDetector, Logger logger) {
        Intrinsics.f(messageDirectionDetector, "messageDirectionDetector");
        Intrinsics.f(logger, "logger");
        this.f39334a = messageDirectionDetector;
        this.f39335b = logger;
        this.f39336c = ChatJsonParserKt.a();
    }

    private final MessageEvent.LifeCycle.Finish b(EndChatEvent endChatEvent) {
        return new MessageEvent.LifeCycle.Finish(ChatMapperKt.e(endChatEvent));
    }

    private final MessageEvent.QuickReply c(QuickReplySuggestionsEvent quickReplySuggestionsEvent) {
        int v7;
        List<QuickReplySuggestionNet> f8 = quickReplySuggestionsEvent.f();
        v7 = CollectionsKt__IterablesKt.v(f8, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (QuickReplySuggestionNet quickReplySuggestionNet : f8) {
            arrayList.add(MessageMapperKt.a(quickReplySuggestionNet));
        }
        return new MessageEvent.QuickReply(arrayList);
    }

    private final MessageEvent d(SeenMessagesEvent seenMessagesEvent) {
        String str;
        ChatMessageSender c8 = seenMessagesEvent.c();
        if (c8 != null) {
            str = c8.a();
        } else {
            str = null;
        }
        if (str == null) {
            return null;
        }
        return new MessageEvent.LifeCycle.MessageSeen(seenMessagesEvent.f(), seenMessagesEvent.c().a());
    }

    private final MessageEvent.Message.Service e(ServiceMessageEvent serviceMessageEvent, String str) {
        return new MessageEvent.Message.Service(MessageMapperKt.f(serviceMessageEvent, str));
    }

    private final MessageEvent.LifeCycle.Start f(StartChatEvent startChatEvent, String str) {
        return new MessageEvent.LifeCycle.Start(ChatMapperKt.c(startChatEvent, str));
    }

    private final MessageEvent g(UserMessageEvent userMessageEvent, String str) {
        UserMessage h8 = MessageMapperKt.h(userMessageEvent, str, this.f39334a);
        if (h8 instanceof UserTextMessage) {
            return new MessageEvent.Message.TextMessage((UserTextMessage) h8);
        }
        return null;
    }

    @Override // eu.bolt.chat.network.data.parser.MqttMessageParser
    public MessageBox a(MqttMessage message) {
        BrokerEvent brokerEvent;
        MessageEvent e8;
        MessageEvent d8;
        Intrinsics.f(message, "message");
        try {
            brokerEvent = (BrokerEvent) this.f39336c.b(BrokerEventSerializer.f39337c, message.b());
        } catch (SerializationException e9) {
            Logger logger = this.f39335b;
            Severity a8 = logger.c().a();
            Severity severity = Severity.Error;
            if (a8.compareTo(severity) <= 0) {
                logger.f(severity, logger.d(), null, "Unable to parse message -> " + e9.getMessage());
            }
            brokerEvent = null;
        }
        if (!(brokerEvent instanceof IncomingChatDomainEvent)) {
            return null;
        }
        IncomingChatDomainEvent incomingChatDomainEvent = (IncomingChatDomainEvent) brokerEvent;
        EventBase a9 = incomingChatDomainEvent.a().a();
        LocalDateTime b8 = DateTimeUtilsKt.b(a9.b());
        if (a9 instanceof StartChatEvent) {
            e8 = f((StartChatEvent) a9, incomingChatDomainEvent.a().b());
        } else if (a9 instanceof EndChatEvent) {
            e8 = b((EndChatEvent) a9);
        } else {
            if (a9 instanceof UserMessageEvent) {
                d8 = g((UserMessageEvent) a9, incomingChatDomainEvent.a().b());
                if (d8 == null) {
                    return null;
                }
            } else if (a9 instanceof QuickReplySuggestionsEvent) {
                e8 = c((QuickReplySuggestionsEvent) a9);
            } else if (a9 instanceof SeenMessagesEvent) {
                d8 = d((SeenMessagesEvent) a9);
                if (d8 == null) {
                    return null;
                }
            } else if (a9 instanceof ServiceMessageEvent) {
                e8 = e((ServiceMessageEvent) a9, incomingChatDomainEvent.a().b());
            } else if (a9 instanceof UnknownMessageEvent) {
                Logger logger2 = this.f39335b;
                Severity a10 = logger2.c().a();
                Severity severity2 = Severity.Info;
                if (a10.compareTo(severity2) <= 0) {
                    logger2.f(severity2, logger2.d(), null, "Received an unknown message event: " + a9);
                }
                return null;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            e8 = d8;
        }
        return new MessageBox(incomingChatDomainEvent.a().b(), e8, b8);
    }
}
