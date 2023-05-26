package eu.bolt.driver.chat.ui.screen.conversation.pager.item.menu;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.core.ui.common.mvvm.ViewModelFactory;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class MessageMenuFragment_Factory implements Factory<MessageMenuFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ViewModelFactory> f40740a;

    public MessageMenuFragment_Factory(Provider<ViewModelFactory> provider) {
        this.f40740a = provider;
    }

    public static MessageMenuFragment_Factory a(Provider<ViewModelFactory> provider) {
        return new MessageMenuFragment_Factory(provider);
    }

    public static MessageMenuFragment c(ViewModelFactory viewModelFactory) {
        return new MessageMenuFragment(viewModelFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MessageMenuFragment get() {
        return c(this.f40740a.get());
    }
}
