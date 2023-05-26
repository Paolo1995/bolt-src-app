package ee.mtakso.driver.di.authorised;

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
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class AuthorisedUiModule_ProvideAuthFragmentFactoryFactory implements Factory<FragmentFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedUiModule f20374a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Map<Class<? extends Fragment>, Provider<Fragment>>> f20375b;

    public AuthorisedUiModule_ProvideAuthFragmentFactoryFactory(AuthorisedUiModule authorisedUiModule, Provider<Map<Class<? extends Fragment>, Provider<Fragment>>> provider) {
        this.f20374a = authorisedUiModule;
        this.f20375b = provider;
    }

    public static AuthorisedUiModule_ProvideAuthFragmentFactoryFactory a(AuthorisedUiModule authorisedUiModule, Provider<Map<Class<? extends Fragment>, Provider<Fragment>>> provider) {
        return new AuthorisedUiModule_ProvideAuthFragmentFactoryFactory(authorisedUiModule, provider);
    }

    public static FragmentFactory c(AuthorisedUiModule authorisedUiModule, Map<Class<? extends Fragment>, Provider<Fragment>> map) {
        return (FragmentFactory) Preconditions.checkNotNullFromProvides(authorisedUiModule.a(map));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public FragmentFactory get() {
        return c(this.f20374a, this.f20375b.get());
    }
}
