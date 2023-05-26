package ee.mtakso.driver.di.authorised;

import androidx.lifecycle.ViewModel;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.ViewModelFactory;
import java.util.Map;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class AuthorisedUiModule_ProvideAuthViewModelFactoryFactory implements Factory<ViewModelFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedUiModule f20376a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> f20377b;

    public AuthorisedUiModule_ProvideAuthViewModelFactoryFactory(AuthorisedUiModule authorisedUiModule, Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> provider) {
        this.f20376a = authorisedUiModule;
        this.f20377b = provider;
    }

    public static AuthorisedUiModule_ProvideAuthViewModelFactoryFactory a(AuthorisedUiModule authorisedUiModule, Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> provider) {
        return new AuthorisedUiModule_ProvideAuthViewModelFactoryFactory(authorisedUiModule, provider);
    }

    public static ViewModelFactory c(AuthorisedUiModule authorisedUiModule, Map<Class<? extends ViewModel>, Provider<ViewModel>> map) {
        return (ViewModelFactory) Preconditions.checkNotNullFromProvides(authorisedUiModule.b(map));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ViewModelFactory get() {
        return c(this.f20376a, this.f20377b.get());
    }
}
