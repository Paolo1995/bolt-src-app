package eu.bolt.chat.chatcore.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.push.ChatPushDelegate;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatCoreModule_ProvidePushDelegateFactory implements Factory<ChatPushDelegate> {

    /* renamed from: a  reason: collision with root package name */
    private final ChatCoreModule f38090a;

    public ChatCoreModule_ProvidePushDelegateFactory(ChatCoreModule chatCoreModule) {
        this.f38090a = chatCoreModule;
    }

    public static ChatCoreModule_ProvidePushDelegateFactory a(ChatCoreModule chatCoreModule) {
        return new ChatCoreModule_ProvidePushDelegateFactory(chatCoreModule);
    }

    public static ChatPushDelegate c(ChatCoreModule chatCoreModule) {
        return (ChatPushDelegate) Preconditions.checkNotNullFromProvides(chatCoreModule.l());
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChatPushDelegate get() {
        return c(this.f38090a);
    }
}
