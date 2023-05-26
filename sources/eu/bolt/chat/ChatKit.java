package eu.bolt.chat;

import eu.bolt.chat.client.ChatClientManager;
import eu.bolt.chat.client.ChatNotificationManager;
import eu.bolt.chat.client.ChatPushHandler;
import eu.bolt.chat.data.connection.ChatConnectionSettings;
import eu.bolt.chat.logger.ClientChatLogger;
import eu.bolt.chat.network.engine.AndroidMqttClientFactory;
import eu.bolt.chat.util.AppStateDispatcher;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatKit.kt */
/* loaded from: classes5.dex */
public final class ChatKit {

    /* renamed from: a  reason: collision with root package name */
    public static final ChatKit f37850a = new ChatKit();

    /* renamed from: b  reason: collision with root package name */
    private static final AppStateDispatcher f37851b = new AppStateDispatcher();

    private ChatKit() {
    }

    public final AppStateDispatcher a() {
        return f37851b;
    }

    public final ChatClientManager b() {
        return ChatCore.f37837a.c();
    }

    public final ChatNotificationManager c() {
        return ChatCore.f37837a.d();
    }

    public final ChatPushHandler d(ClientChatLogger logger) {
        Intrinsics.f(logger, "logger");
        return ChatCore.f37837a.e(logger);
    }

    public final void e(ChatConnectionSettings settings, ClientChatLogger logger) {
        Intrinsics.f(settings, "settings");
        Intrinsics.f(logger, "logger");
        ChatCore chatCore = ChatCore.f37837a;
        chatCore.i(new AndroidMqttClientFactory(), settings, logger);
        f37851b.c(chatCore.f());
    }
}
