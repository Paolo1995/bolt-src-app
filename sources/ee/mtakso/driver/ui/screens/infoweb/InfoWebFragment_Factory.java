package ee.mtakso.driver.ui.screens.infoweb;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class InfoWebFragment_Factory implements Factory<InfoWebFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f30377a;

    public InfoWebFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f30377a = provider;
    }

    public static InfoWebFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new InfoWebFragment_Factory(provider);
    }

    public static InfoWebFragment c(BaseUiDependencies baseUiDependencies) {
        return new InfoWebFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public InfoWebFragment get() {
        return c(this.f30377a.get());
    }
}
