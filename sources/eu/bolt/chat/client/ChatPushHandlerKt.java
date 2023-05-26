package eu.bolt.chat.client;

import co.touchlab.kermit.Logger;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatPushHandler.kt */
/* loaded from: classes5.dex */
public final class ChatPushHandlerKt {
    public static final InternalChatPushHandler a(ChatPushParser pushParser, Logger logger) {
        Intrinsics.f(pushParser, "pushParser");
        Intrinsics.f(logger, "logger");
        return new DefaultChatPushHandler(pushParser, logger);
    }
}
