package eu.bolt.driver.chat.ui.screen.conversation.pager.item;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.connection.ChatConnectionProvider;
import eu.bolt.chat.chatcore.interactor.RequestReplySuggestionsInteractor;
import eu.bolt.chat.chatcore.interactor.SendChatMessageInteractor;
import eu.bolt.chat.chatcore.repo.ChatRepo;
import eu.bolt.driver.chat.service.analytics.ChatAnalytics;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ConversationViewModel_Factory implements Factory<ConversationViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ChatRepo> f40694a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SendChatMessageInteractor> f40695b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<RequestReplySuggestionsInteractor> f40696c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ChatAnalytics> f40697d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<ChatConnectionProvider> f40698e;

    public ConversationViewModel_Factory(Provider<ChatRepo> provider, Provider<SendChatMessageInteractor> provider2, Provider<RequestReplySuggestionsInteractor> provider3, Provider<ChatAnalytics> provider4, Provider<ChatConnectionProvider> provider5) {
        this.f40694a = provider;
        this.f40695b = provider2;
        this.f40696c = provider3;
        this.f40697d = provider4;
        this.f40698e = provider5;
    }

    public static ConversationViewModel_Factory a(Provider<ChatRepo> provider, Provider<SendChatMessageInteractor> provider2, Provider<RequestReplySuggestionsInteractor> provider3, Provider<ChatAnalytics> provider4, Provider<ChatConnectionProvider> provider5) {
        return new ConversationViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static ConversationViewModel c(ChatRepo chatRepo, SendChatMessageInteractor sendChatMessageInteractor, RequestReplySuggestionsInteractor requestReplySuggestionsInteractor, ChatAnalytics chatAnalytics, ChatConnectionProvider chatConnectionProvider) {
        return new ConversationViewModel(chatRepo, sendChatMessageInteractor, requestReplySuggestionsInteractor, chatAnalytics, chatConnectionProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ConversationViewModel get() {
        return c(this.f40694a.get(), this.f40695b.get(), this.f40696c.get(), this.f40697d.get(), this.f40698e.get());
    }
}
