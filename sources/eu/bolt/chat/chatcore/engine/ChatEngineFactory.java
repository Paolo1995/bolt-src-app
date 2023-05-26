package eu.bolt.chat.chatcore.engine;

import eu.bolt.chat.chatcore.push.ChatPushHandler;
import eu.bolt.chat.chatcore.push.PushHandlerDependencies;
import eu.bolt.chat.chatcore.repo.InternalChatRepo;

/* compiled from: ChatEngineFactory.kt */
/* loaded from: classes5.dex */
public interface ChatEngineFactory {
    InternalChatRepo a(ChatEngineDependencies chatEngineDependencies);

    ChatPushHandler b(PushHandlerDependencies pushHandlerDependencies);
}
