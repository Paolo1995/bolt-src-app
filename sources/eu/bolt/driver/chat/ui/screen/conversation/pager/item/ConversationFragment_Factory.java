package eu.bolt.driver.chat.ui.screen.conversation.pager.item;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.android.chat.recyclerview.ChatReadDelegate;
import eu.bolt.driver.chat.helper.SoundEffectsPool;
import eu.bolt.driver.core.di.helper.CoreFragmentFactory;
import eu.bolt.driver.core.ui.base.fragment.BaseFragmentParams;
import eu.bolt.driver.core.ui.common.mvvm.ViewModelFactory;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ConversationFragment_Factory implements Factory<ConversationFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseFragmentParams> f40663a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ViewModelFactory> f40664b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<MessageMapper> f40665c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<CoreFragmentFactory> f40666d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<ChatReadDelegate> f40667e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<SoundEffectsPool> f40668f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<RoutingManager> f40669g;

    public ConversationFragment_Factory(Provider<BaseFragmentParams> provider, Provider<ViewModelFactory> provider2, Provider<MessageMapper> provider3, Provider<CoreFragmentFactory> provider4, Provider<ChatReadDelegate> provider5, Provider<SoundEffectsPool> provider6, Provider<RoutingManager> provider7) {
        this.f40663a = provider;
        this.f40664b = provider2;
        this.f40665c = provider3;
        this.f40666d = provider4;
        this.f40667e = provider5;
        this.f40668f = provider6;
        this.f40669g = provider7;
    }

    public static ConversationFragment_Factory a(Provider<BaseFragmentParams> provider, Provider<ViewModelFactory> provider2, Provider<MessageMapper> provider3, Provider<CoreFragmentFactory> provider4, Provider<ChatReadDelegate> provider5, Provider<SoundEffectsPool> provider6, Provider<RoutingManager> provider7) {
        return new ConversationFragment_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static ConversationFragment c(BaseFragmentParams baseFragmentParams, ViewModelFactory viewModelFactory, MessageMapper messageMapper, CoreFragmentFactory coreFragmentFactory, ChatReadDelegate chatReadDelegate, SoundEffectsPool soundEffectsPool, RoutingManager routingManager) {
        return new ConversationFragment(baseFragmentParams, viewModelFactory, messageMapper, coreFragmentFactory, chatReadDelegate, soundEffectsPool, routingManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ConversationFragment get() {
        return c(this.f40663a.get(), this.f40664b.get(), this.f40665c.get(), this.f40666d.get(), this.f40667e.get(), this.f40668f.get(), this.f40669g.get());
    }
}
