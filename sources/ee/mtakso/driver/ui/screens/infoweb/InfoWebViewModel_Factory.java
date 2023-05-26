package ee.mtakso.driver.ui.screens.infoweb;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class InfoWebViewModel_Factory implements Factory<InfoWebViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<CompositeUrlLauncher> f30386a;

    public InfoWebViewModel_Factory(Provider<CompositeUrlLauncher> provider) {
        this.f30386a = provider;
    }

    public static InfoWebViewModel_Factory a(Provider<CompositeUrlLauncher> provider) {
        return new InfoWebViewModel_Factory(provider);
    }

    public static InfoWebViewModel c(CompositeUrlLauncher compositeUrlLauncher) {
        return new InfoWebViewModel(compositeUrlLauncher);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public InfoWebViewModel get() {
        return c(this.f30386a.get());
    }
}
