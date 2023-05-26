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
public final class DeactivateDestinationInteractor_Factory implements Factory<DeactivateDestinationInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverDestinationsManager> f26429a;

    public DeactivateDestinationInteractor_Factory(Provider<DriverDestinationsManager> provider) {
        this.f26429a = provider;
    }

    public static DeactivateDestinationInteractor_Factory a(Provider<DriverDestinationsManager> provider) {
        return new DeactivateDestinationInteractor_Factory(provider);
    }

    public static DeactivateDestinationInteractor c(DriverDestinationsManager driverDestinationsManager) {
        return new DeactivateDestinationInteractor(driverDestinationsManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DeactivateDestinationInteractor get() {
        return c(this.f26429a.get());
    }
}
