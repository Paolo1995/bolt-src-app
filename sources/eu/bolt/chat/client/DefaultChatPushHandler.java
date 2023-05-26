package eu.bolt.chat.client;

import co.touchlab.kermit.Logger;
import co.touchlab.kermit.Severity;
import eu.bolt.chat.data.ChatPushHandlerResult;
import eu.bolt.chat.data.ChatPushMessage;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: ChatPushHandler.kt */
/* loaded from: classes5.dex */
final class DefaultChatPushHandler implements InternalChatPushHandler {

    /* renamed from: a  reason: collision with root package name */
    private final ChatPushParser f38849a;

    /* renamed from: b  reason: collision with root package name */
    private final Logger f38850b;

    /* renamed from: c  reason: collision with root package name */
    private final Channel<ChatPushMessage> f38851c;

    /* renamed from: d  reason: collision with root package name */
    private final Flow<ChatPushMessage> f38852d;

    public DefaultChatPushHandler(ChatPushParser pushParser, Logger logger) {
        Intrinsics.f(pushParser, "pushParser");
        Intrinsics.f(logger, "logger");
        this.f38849a = pushParser;
        this.f38850b = logger;
        Channel<ChatPushMessage> b8 = ChannelKt.b(0, null, null, 6, null);
        this.f38851c = b8;
        this.f38852d = FlowKt.G(b8);
    }

    @Override // eu.bolt.chat.client.ChatPushReceiver
    public Flow<ChatPushMessage> a() {
        return this.f38852d;
    }

    @Override // eu.bolt.chat.client.ChatPushHandler
    public ChatPushHandlerResult b(ChatPushPayload payload) {
        Intrinsics.f(payload, "payload");
        if (!this.f38849a.b(payload)) {
            return ChatPushHandlerResult.Failure.f38935a;
        }
        ChatPushMessage a8 = this.f38849a.a(payload);
        if (a8 == null) {
            Logger logger = this.f38850b;
            Severity a9 = logger.c().a();
            Severity severity = Severity.Warn;
            if (a9.compareTo(severity) <= 0) {
                logger.f(severity, logger.d(), null, "Push message payload has unsupported format");
            }
            return ChatPushHandlerResult.Failure.f38935a;
        } else if (ChannelResult.j(this.f38851c.u(a8))) {
            return ChatPushHandlerResult.Success.f38937a;
        } else {
            Logger logger2 = this.f38850b;
            Severity a10 = logger2.c().a();
            Severity severity2 = Severity.Info;
            if (a10.compareTo(severity2) <= 0) {
                logger2.f(severity2, logger2.d(), null, "Push message is not handled. Client is not connected.");
            }
            return new ChatPushHandlerResult.NotPublished(a8);
        }
    }
}
