package ee.mtakso.driver.ui.screens.sos;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes5.dex */
public final class SosDialogFragment_Factory implements Factory<SosDialogFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f33397a;

    public SosDialogFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f33397a = provider;
    }

    public static SosDialogFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new SosDialogFragment_Factory(provider);
    }

    public static SosDialogFragment c(BaseUiDependencies baseUiDependencies) {
        return new SosDialogFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SosDialogFragment get() {
        return c(this.f33397a.get());
    }
}
