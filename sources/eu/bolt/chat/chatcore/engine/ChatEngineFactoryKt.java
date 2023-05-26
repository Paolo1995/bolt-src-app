package eu.bolt.chat.chatcore.engine;

import eu.bolt.chat.chatcore.chatsdk.AnonymousChatSdkProvider;
import eu.bolt.chat.chatcore.chatsdk.ChatSdkChatEngineFactory;
import eu.bolt.chat.chatcore.chatsdk.ChatSdkInitializer;
import eu.bolt.chat.chatcore.engine.ChatEngineType;
import eu.bolt.chat.chatcore.repo.DefaultChatEngineFactory;
import eu.bolt.chat.tools.logger.Logger;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatEngineFactory.kt */
/* loaded from: classes5.dex */
public final class ChatEngineFactoryKt {
    public static final ChatEngineFactory a(Lazy<? extends AnonymousChatSdkProvider> chatSdkProvider, Lazy<? extends ChatSdkInitializer> chatSdkInitializer, ChatEngineTypeProvider engineTypeProvider, Logger logger) {
        Intrinsics.f(chatSdkProvider, "chatSdkProvider");
        Intrinsics.f(chatSdkInitializer, "chatSdkInitializer");
        Intrinsics.f(engineTypeProvider, "engineTypeProvider");
        Intrinsics.f(logger, "logger");
        ChatEngineType a8 = engineTypeProvider.a();
        if (a8 instanceof ChatEngineType.ChatSdk) {
            logger.b("Creating Chat SDK chat engine factory");
            return new ChatSdkChatEngineFactory(chatSdkInitializer.getValue(), chatSdkProvider.getValue(), logger);
        } else if (a8 instanceof ChatEngineType.Default) {
            logger.b("Creating a default chat engine factory");
            return new DefaultChatEngineFactory(logger);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
