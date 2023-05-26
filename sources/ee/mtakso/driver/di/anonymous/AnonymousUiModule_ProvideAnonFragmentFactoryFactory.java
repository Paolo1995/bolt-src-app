package ee.mtakso.driver.di.anonymous;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Map;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AnonymousUiModule_ProvideAnonFragmentFactoryFactory implements Factory<FragmentFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final AnonymousUiModule f20178a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Map<Class<? extends Fragment>, Provider<Fragment>>> f20179b;

    public AnonymousUiModule_ProvideAnonFragmentFactoryFactory(AnonymousUiModule anonymousUiModule, Provider<Map<Class<? extends Fragment>, Provider<Fragment>>> provider) {
        this.f20178a = anonymousUiModule;
        this.f20179b = provider;
    }

    public static AnonymousUiModule_ProvideAnonFragmentFactoryFactory a(AnonymousUiModule anonymousUiModule, Provider<Map<Class<? extends Fragment>, Provider<Fragment>>> provider) {
        return new AnonymousUiModule_ProvideAnonFragmentFactoryFactory(anonymousUiModule, provider);
    }

    public static FragmentFactory c(AnonymousUiModule anonymousUiModule, Map<Class<? extends Fragment>, Provider<Fragment>> map) {
        return (FragmentFactory) Preconditions.checkNotNullFromProvides(anonymousUiModule.a(map));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public FragmentFactory get() {
        return c(this.f20178a, this.f20179b.get());
    }
}
