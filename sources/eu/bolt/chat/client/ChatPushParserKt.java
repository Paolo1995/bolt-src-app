package eu.bolt.chat.client;

import co.touchlab.kermit.Logger;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatPushParser.kt */
/* loaded from: classes5.dex */
public final class ChatPushParserKt {
    public static final ChatPushParser a(Logger logger) {
        Intrinsics.f(logger, "logger");
        return new DefaultChatPushParser(logger);
    }
}
