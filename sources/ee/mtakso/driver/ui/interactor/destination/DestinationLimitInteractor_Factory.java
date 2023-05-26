package ee.mtakso.driver.ui.interactor.destination;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DestinationLimitInteractor_Factory implements Factory<DestinationLimitInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverDestinationsManager> f26433a;

    public DestinationLimitInteractor_Factory(Provider<DriverDestinationsManager> provider) {
        this.f26433a = provider;
    }

    public static DestinationLimitInteractor_Factory a(Provider<DriverDestinationsManager> provider) {
        return new DestinationLimitInteractor_Factory(provider);
    }

    public static DestinationLimitInteractor c(DriverDestinationsManager driverDestinationsManager) {
        return new DestinationLimitInteractor(driverDestinationsManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DestinationLimitInteractor get() {
        return c(this.f26433a.get());
    }
}
