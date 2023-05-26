package eu.bolt.chat.chatcore.chatsdk;

import eu.bolt.chat.ChatKit;
import eu.bolt.chat.chatcore.chatsdk.logger.ChatLogger;
import eu.bolt.chat.client.ChatPushHandler;
import eu.bolt.chat.tools.logger.Logger;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnonymousChatSdkProvider.kt */
/* loaded from: classes5.dex */
final class AnonymousChatSdkProviderImpl implements AnonymousChatSdkProvider {

    /* renamed from: a  reason: collision with root package name */
    private final ChatLogger f37891a;

    public AnonymousChatSdkProviderImpl(Logger logger) {
        Intrinsics.f(logger, "logger");
        this.f37891a = new ChatLogger(logger);
    }

    @Override // eu.bolt.chat.chatcore.chatsdk.AnonymousChatSdkProvider
    public ChatPushHandler a() {
        return ChatKit.f37850a.d(this.f37891a);
    }
}
