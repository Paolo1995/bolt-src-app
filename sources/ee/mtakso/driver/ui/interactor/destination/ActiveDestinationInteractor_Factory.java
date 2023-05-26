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
public final class ActiveDestinationInteractor_Factory implements Factory<ActiveDestinationInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverDestinationsManager> f26427a;

    public ActiveDestinationInteractor_Factory(Provider<DriverDestinationsManager> provider) {
        this.f26427a = provider;
    }

    public static ActiveDestinationInteractor_Factory a(Provider<DriverDestinationsManager> provider) {
        return new ActiveDestinationInteractor_Factory(provider);
    }

    public static ActiveDestinationInteractor c(DriverDestinationsManager driverDestinationsManager) {
        return new ActiveDestinationInteractor(driverDestinationsManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ActiveDestinationInteractor get() {
        return c(this.f26427a.get());
    }
}
