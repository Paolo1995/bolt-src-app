package ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class ActiveIncidentDialogFragment_Factory implements Factory<ActiveIncidentDialogFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f32664a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverSettings> f32665b;

    public ActiveIncidentDialogFragment_Factory(Provider<BaseUiDependencies> provider, Provider<DriverSettings> provider2) {
        this.f32664a = provider;
        this.f32665b = provider2;
    }

    public static ActiveIncidentDialogFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<DriverSettings> provider2) {
        return new ActiveIncidentDialogFragment_Factory(provider, provider2);
    }

    public static ActiveIncidentDialogFragment c(BaseUiDependencies baseUiDependencies, DriverSettings driverSettings) {
        return new ActiveIncidentDialogFragment(baseUiDependencies, driverSettings);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ActiveIncidentDialogFragment get() {
        return c(this.f32664a.get(), this.f32665b.get());
    }
}
