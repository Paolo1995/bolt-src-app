package ee.mtakso.driver.di.anonymous;

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
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AnonymousUiModule_ProvideAnonViewModelFactoryFactory implements Factory<ViewModelFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final AnonymousUiModule f20180a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> f20181b;

    public AnonymousUiModule_ProvideAnonViewModelFactoryFactory(AnonymousUiModule anonymousUiModule, Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> provider) {
        this.f20180a = anonymousUiModule;
        this.f20181b = provider;
    }

    public static AnonymousUiModule_ProvideAnonViewModelFactoryFactory a(AnonymousUiModule anonymousUiModule, Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> provider) {
        return new AnonymousUiModule_ProvideAnonViewModelFactoryFactory(anonymousUiModule, provider);
    }

    public static ViewModelFactory c(AnonymousUiModule anonymousUiModule, Map<Class<? extends ViewModel>, Provider<ViewModel>> map) {
        return (ViewModelFactory) Preconditions.checkNotNullFromProvides(anonymousUiModule.b(map));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ViewModelFactory get() {
        return c(this.f20180a, this.f20181b.get());
    }
}
