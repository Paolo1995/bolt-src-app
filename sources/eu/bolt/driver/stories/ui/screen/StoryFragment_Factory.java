package eu.bolt.driver.stories.ui.screen;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.core.ui.base.fragment.BaseFragmentParams;
import eu.bolt.driver.core.ui.common.mvvm.ViewModelFactory;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class StoryFragment_Factory implements Factory<StoryFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseFragmentParams> f41555a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ViewModelFactory> f41556b;

    public StoryFragment_Factory(Provider<BaseFragmentParams> provider, Provider<ViewModelFactory> provider2) {
        this.f41555a = provider;
        this.f41556b = provider2;
    }

    public static StoryFragment_Factory a(Provider<BaseFragmentParams> provider, Provider<ViewModelFactory> provider2) {
        return new StoryFragment_Factory(provider, provider2);
    }

    public static StoryFragment c(BaseFragmentParams baseFragmentParams, ViewModelFactory viewModelFactory) {
        return new StoryFragment(baseFragmentParams, viewModelFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public StoryFragment get() {
        return c(this.f41555a.get(), this.f41556b.get());
    }
}
