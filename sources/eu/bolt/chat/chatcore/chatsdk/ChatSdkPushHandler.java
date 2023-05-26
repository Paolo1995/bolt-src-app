package eu.bolt.chat.chatcore.chatsdk;

import eu.bolt.chat.chatcore.chatsdk.mapper.ChatMapper;
import eu.bolt.chat.chatcore.chatsdk.mapper.MessageMapper;
import eu.bolt.chat.chatcore.push.ChatPushDelegate;
import eu.bolt.chat.chatcore.push.ChatPushHandler;
import eu.bolt.chat.client.AndroidChatPushPayload;
import eu.bolt.chat.data.ChatPushHandlerResult;
import eu.bolt.chat.data.ChatPushMessage;
import eu.bolt.chat.tools.logger.Logger;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: ChatSdkPushHandler.kt */
/* loaded from: classes5.dex */
public final class ChatSdkPushHandler implements ChatPushHandler {

    /* renamed from: a  reason: collision with root package name */
    private final AnonymousChatSdkProvider f38053a;

    /* renamed from: b  reason: collision with root package name */
    private final ChatMapper f38054b;

    /* renamed from: c  reason: collision with root package name */
    private final MessageMapper f38055c;

    /* renamed from: d  reason: collision with root package name */
    private final ChatPushDelegate f38056d;

    /* renamed from: e  reason: collision with root package name */
    private final Logger f38057e;

    public ChatSdkPushHandler(AnonymousChatSdkProvider chatSdkProvider, ChatMapper chatMapper, MessageMapper messageMapper, ChatPushDelegate chatPushDelegate, Logger logger) {
        Intrinsics.f(chatSdkProvider, "chatSdkProvider");
        Intrinsics.f(chatMapper, "chatMapper");
        Intrinsics.f(messageMapper, "messageMapper");
        Intrinsics.f(chatPushDelegate, "chatPushDelegate");
        Intrinsics.f(logger, "logger");
        this.f38053a = chatSdkProvider;
        this.f38054b = chatMapper;
        this.f38055c = messageMapper;
        this.f38056d = chatPushDelegate;
        this.f38057e = logger;
    }

    @Override // eu.bolt.chat.chatcore.push.ChatPushHandler
    public boolean a(Map<String, String> data) {
        Intrinsics.f(data, "data");
        ChatPushHandlerResult b8 = this.f38053a.a().b(new AndroidChatPushPayload(data));
        if (Intrinsics.a(b8, ChatPushHandlerResult.Failure.f38935a)) {
            return false;
        }
        if (Intrinsics.a(b8, ChatPushHandlerResult.Success.f38937a)) {
            Logger logger = this.f38057e;
            logger.b("Push " + data.get(Name.MARK) + " handled successfully");
            return true;
        } else if (b8 instanceof ChatPushHandlerResult.NotPublished) {
            ChatPushMessage a8 = ((ChatPushHandlerResult.NotPublished) b8).a();
            this.f38056d.b(this.f38054b.a(a8.c()), this.f38055c.a(a8.d()));
            return true;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
