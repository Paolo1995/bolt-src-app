package ee.mtakso.driver.ui.interactor.driver;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverStateInteractor_Factory implements Factory<DriverStateInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverStatusProvider> f26473a;

    public DriverStateInteractor_Factory(Provider<DriverStatusProvider> provider) {
        this.f26473a = provider;
    }

    public static DriverStateInteractor_Factory a(Provider<DriverStatusProvider> provider) {
        return new DriverStateInteractor_Factory(provider);
    }

    public static DriverStateInteractor c(DriverStatusProvider driverStatusProvider) {
        return new DriverStateInteractor(driverStatusProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverStateInteractor get() {
        return c(this.f26473a.get());
    }
}
