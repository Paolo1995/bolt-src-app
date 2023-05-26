package ee.mtakso.driver.di.authorised;

import androidx.lifecycle.ViewModel;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.core.ui.common.mvvm.ViewModelFactory;
import java.util.Map;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AuthorisedCoreModule_ProvideViewModelFactoryFactory implements Factory<ViewModelFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedCoreModule f20289a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> f20290b;

    public AuthorisedCoreModule_ProvideViewModelFactoryFactory(AuthorisedCoreModule authorisedCoreModule, Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> provider) {
        this.f20289a = authorisedCoreModule;
        this.f20290b = provider;
    }

    public static AuthorisedCoreModule_ProvideViewModelFactoryFactory a(AuthorisedCoreModule authorisedCoreModule, Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> provider) {
        return new AuthorisedCoreModule_ProvideViewModelFactoryFactory(authorisedCoreModule, provider);
    }

    public static ViewModelFactory c(AuthorisedCoreModule authorisedCoreModule, Map<Class<? extends ViewModel>, Provider<ViewModel>> map) {
        return (ViewModelFactory) Preconditions.checkNotNullFromProvides(authorisedCoreModule.g(map));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ViewModelFactory get() {
        return c(this.f20289a, this.f20290b.get());
    }
}
