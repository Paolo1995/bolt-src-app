package ee.mtakso.driver.ui.screens.vehicle;

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
public final class VehicleListFragment_Factory implements Factory<VehicleListFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f33518a;

    public VehicleListFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f33518a = provider;
    }

    public static VehicleListFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new VehicleListFragment_Factory(provider);
    }

    public static VehicleListFragment c(BaseUiDependencies baseUiDependencies) {
        return new VehicleListFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public VehicleListFragment get() {
        return c(this.f33518a.get());
    }
}
