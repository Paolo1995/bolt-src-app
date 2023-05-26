package ee.mtakso.driver.ui.screens.navigator_chooser;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class NavigatorChooserFragment_Factory implements Factory<NavigatorChooserFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f30922a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverFeatures> f30923b;

    public NavigatorChooserFragment_Factory(Provider<BaseUiDependencies> provider, Provider<DriverFeatures> provider2) {
        this.f30922a = provider;
        this.f30923b = provider2;
    }

    public static NavigatorChooserFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<DriverFeatures> provider2) {
        return new NavigatorChooserFragment_Factory(provider, provider2);
    }

    public static NavigatorChooserFragment c(BaseUiDependencies baseUiDependencies, DriverFeatures driverFeatures) {
        return new NavigatorChooserFragment(baseUiDependencies, driverFeatures);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public NavigatorChooserFragment get() {
        return c(this.f30922a.get(), this.f30923b.get());
    }
}
