package eu.bolt.driver.chat.ui.screen.conversation.pager;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.core.di.helper.CoreFragmentFactory;
import eu.bolt.driver.core.ui.base.fragment.BaseFragmentParams;
import eu.bolt.driver.core.ui.common.mvvm.ViewModelFactory;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ConversationPagerFragment_Factory implements Factory<ConversationPagerFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseFragmentParams> f40615a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ViewModelFactory> f40616b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<CoreFragmentFactory> f40617c;

    public ConversationPagerFragment_Factory(Provider<BaseFragmentParams> provider, Provider<ViewModelFactory> provider2, Provider<CoreFragmentFactory> provider3) {
        this.f40615a = provider;
        this.f40616b = provider2;
        this.f40617c = provider3;
    }

    public static ConversationPagerFragment_Factory a(Provider<BaseFragmentParams> provider, Provider<ViewModelFactory> provider2, Provider<CoreFragmentFactory> provider3) {
        return new ConversationPagerFragment_Factory(provider, provider2, provider3);
    }

    public static ConversationPagerFragment c(BaseFragmentParams baseFragmentParams, ViewModelFactory viewModelFactory, CoreFragmentFactory coreFragmentFactory) {
        return new ConversationPagerFragment(baseFragmentParams, viewModelFactory, coreFragmentFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ConversationPagerFragment get() {
        return c(this.f40615a.get(), this.f40616b.get(), this.f40617c.get());
    }
}
