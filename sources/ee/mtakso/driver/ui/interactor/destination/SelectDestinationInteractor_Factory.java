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
public final class SelectDestinationInteractor_Factory implements Factory<SelectDestinationInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverDestinationsManager> f26438a;

    public SelectDestinationInteractor_Factory(Provider<DriverDestinationsManager> provider) {
        this.f26438a = provider;
    }

    public static SelectDestinationInteractor_Factory a(Provider<DriverDestinationsManager> provider) {
        return new SelectDestinationInteractor_Factory(provider);
    }

    public static SelectDestinationInteractor c(DriverDestinationsManager driverDestinationsManager) {
        return new SelectDestinationInteractor(driverDestinationsManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SelectDestinationInteractor get() {
        return c(this.f26438a.get());
    }
}
