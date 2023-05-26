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
public final class DistinctDriverStateInteractor_Factory implements Factory<DistinctDriverStateInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverStatusProvider> f26446a;

    public DistinctDriverStateInteractor_Factory(Provider<DriverStatusProvider> provider) {
        this.f26446a = provider;
    }

    public static DistinctDriverStateInteractor_Factory a(Provider<DriverStatusProvider> provider) {
        return new DistinctDriverStateInteractor_Factory(provider);
    }

    public static DistinctDriverStateInteractor c(DriverStatusProvider driverStatusProvider) {
        return new DistinctDriverStateInteractor(driverStatusProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DistinctDriverStateInteractor get() {
        return c(this.f26446a.get());
    }
}
