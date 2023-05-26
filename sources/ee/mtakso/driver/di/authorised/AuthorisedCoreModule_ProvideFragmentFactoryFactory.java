package ee.mtakso.driver.di.authorised;

import androidx.fragment.app.Fragment;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.core.di.helper.CoreFragmentFactory;
import java.util.Map;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AuthorisedCoreModule_ProvideFragmentFactoryFactory implements Factory<CoreFragmentFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedCoreModule f20285a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Map<Class<? extends Fragment>, Provider<Fragment>>> f20286b;

    public AuthorisedCoreModule_ProvideFragmentFactoryFactory(AuthorisedCoreModule authorisedCoreModule, Provider<Map<Class<? extends Fragment>, Provider<Fragment>>> provider) {
        this.f20285a = authorisedCoreModule;
        this.f20286b = provider;
    }

    public static AuthorisedCoreModule_ProvideFragmentFactoryFactory a(AuthorisedCoreModule authorisedCoreModule, Provider<Map<Class<? extends Fragment>, Provider<Fragment>>> provider) {
        return new AuthorisedCoreModule_ProvideFragmentFactoryFactory(authorisedCoreModule, provider);
    }

    public static CoreFragmentFactory c(AuthorisedCoreModule authorisedCoreModule, Map<Class<? extends Fragment>, Provider<Fragment>> map) {
        return (CoreFragmentFactory) Preconditions.checkNotNullFromProvides(authorisedCoreModule.b(map));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CoreFragmentFactory get() {
        return c(this.f20285a, this.f20286b.get());
    }
}
