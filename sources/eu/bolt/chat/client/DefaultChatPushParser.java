package eu.bolt.chat.client;

import co.touchlab.kermit.Logger;
import co.touchlab.kermit.Severity;
import eu.bolt.chat.data.ChatPushMessage;
import eu.bolt.chat.data.mapper.PushMessageMapperKt;
import eu.bolt.chat.data.util.MessageDirectionDetector;
import eu.bolt.chat.network.data.ChatPushMessageNet;
import eu.bolt.chat.network.data.MessageEventBase;
import eu.bolt.chat.network.data.parser.ChatJsonParserKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;

/* compiled from: ChatPushParser.kt */
/* loaded from: classes5.dex */
final class DefaultChatPushParser implements ChatPushParser {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f38853c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Logger f38854a;

    /* renamed from: b  reason: collision with root package name */
    private final Json f38855b;

    /* compiled from: ChatPushParser.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ChatPushParser.kt */
    /* loaded from: classes5.dex */
    private static final class PushMessageDirectionDetector implements MessageDirectionDetector {

        /* renamed from: a  reason: collision with root package name */
        public static final PushMessageDirectionDetector f38856a = new PushMessageDirectionDetector();

        private PushMessageDirectionDetector() {
        }

        @Override // eu.bolt.chat.data.util.MessageDirectionDetector
        public boolean a(MessageEventBase message) {
            Intrinsics.f(message, "message");
            return false;
        }
    }

    public DefaultChatPushParser(Logger logger) {
        Intrinsics.f(logger, "logger");
        this.f38854a = logger;
        this.f38855b = ChatJsonParserKt.a();
    }

    @Override // eu.bolt.chat.client.ChatPushParser
    public ChatPushMessage a(ChatPushPayload payload) {
        Intrinsics.f(payload, "payload");
        String domain = payload.getDomain();
        if (domain == null) {
            domain = "unknown";
        }
        if (Intrinsics.a(domain, "chat")) {
            String body = payload.getBody();
            if (body != null && body.length() != 0) {
                try {
                    Json json = this.f38855b;
                    KSerializer<Object> c8 = SerializersKt.c(json.a(), Reflection.i(ChatPushMessageNet.class));
                    Intrinsics.d(c8, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    ChatPushMessageNet chatPushMessageNet = (ChatPushMessageNet) json.b(c8, body);
                    ChatPushMessage b8 = PushMessageMapperKt.b(chatPushMessageNet, PushMessageDirectionDetector.f38856a);
                    if (b8 == null) {
                        MessageEventBase c9 = chatPushMessageNet.c();
                        Logger logger = this.f38854a;
                        Severity a8 = logger.c().a();
                        Severity severity = Severity.Warn;
                        if (a8.compareTo(severity) <= 0) {
                            String d8 = logger.d();
                            logger.f(severity, d8, null, "Chat event " + c9 + " is not expected to be in a push message payload or it's invalid");
                        }
                    }
                    return b8;
                } catch (SerializationException e8) {
                    Logger logger2 = this.f38854a;
                    Severity a9 = logger2.c().a();
                    Severity severity2 = Severity.Error;
                    if (a9.compareTo(severity2) > 0) {
                        return null;
                    }
                    String d9 = logger2.d();
                    logger2.f(severity2, d9, null, "Unable to parse push message payload -> " + e8.getMessage());
                    return null;
                }
            }
            Logger logger3 = this.f38854a;
            Severity a10 = logger3.c().a();
            Severity severity3 = Severity.Warn;
            if (a10.compareTo(severity3) <= 0) {
                logger3.f(severity3, logger3.d(), null, "Chat data is missing in the push payload for domain chat");
            }
            return null;
        }
        throw new IllegalArgumentException(("Push payload belongs to an unsupported domain: " + domain).toString());
    }

    @Override // eu.bolt.chat.client.ChatPushParser
    public boolean b(ChatPushPayload payload) {
        Intrinsics.f(payload, "payload");
        return Intrinsics.a(payload.getDomain(), "chat");
    }
}
