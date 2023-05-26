package eu.bolt.driver.chat.ui.screen.conversation.pager;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.chat.ActiveOrdersSource;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ConversationPagerViewModel_Factory implements Factory<ConversationPagerViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ActiveOrdersSource> f40624a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ConversationMapper> f40625b;

    public ConversationPagerViewModel_Factory(Provider<ActiveOrdersSource> provider, Provider<ConversationMapper> provider2) {
        this.f40624a = provider;
        this.f40625b = provider2;
    }

    public static ConversationPagerViewModel_Factory a(Provider<ActiveOrdersSource> provider, Provider<ConversationMapper> provider2) {
        return new ConversationPagerViewModel_Factory(provider, provider2);
    }

    public static ConversationPagerViewModel c(ActiveOrdersSource activeOrdersSource, ConversationMapper conversationMapper) {
        return new ConversationPagerViewModel(activeOrdersSource, conversationMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ConversationPagerViewModel get() {
        return c(this.f40624a.get(), this.f40625b.get());
    }
}
