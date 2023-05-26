package eu.bolt.chat.chatcore.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.repo.quickreply.QuickRepliesDelegate;
import eu.bolt.chat.chatcore.repo.quickreply.QuickRepliesDelegateImpl;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatCoreModule_ProvideQuickReplyDelegate$chat_core_releaseFactory implements Factory<QuickRepliesDelegate> {

    /* renamed from: a  reason: collision with root package name */
    private final ChatCoreModule f38091a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<QuickRepliesDelegateImpl> f38092b;

    public ChatCoreModule_ProvideQuickReplyDelegate$chat_core_releaseFactory(ChatCoreModule chatCoreModule, Provider<QuickRepliesDelegateImpl> provider) {
        this.f38091a = chatCoreModule;
        this.f38092b = provider;
    }

    public static ChatCoreModule_ProvideQuickReplyDelegate$chat_core_releaseFactory a(ChatCoreModule chatCoreModule, Provider<QuickRepliesDelegateImpl> provider) {
        return new ChatCoreModule_ProvideQuickReplyDelegate$chat_core_releaseFactory(chatCoreModule, provider);
    }

    public static QuickRepliesDelegate c(ChatCoreModule chatCoreModule, QuickRepliesDelegateImpl quickRepliesDelegateImpl) {
        return (QuickRepliesDelegate) Preconditions.checkNotNullFromProvides(chatCoreModule.m(quickRepliesDelegateImpl));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public QuickRepliesDelegate get() {
        return c(this.f38091a, this.f38092b.get());
    }
}
