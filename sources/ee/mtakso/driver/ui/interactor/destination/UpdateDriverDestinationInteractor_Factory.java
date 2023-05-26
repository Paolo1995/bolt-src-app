package ee.mtakso.driver.ui.interactor.destination;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.ui.interactor.search.GetExternalSourceAddressDetailInteractor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class UpdateDriverDestinationInteractor_Factory implements Factory<UpdateDriverDestinationInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverDestinationsManager> f26443a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<GetExternalSourceAddressDetailInteractor> f26444b;

    public UpdateDriverDestinationInteractor_Factory(Provider<DriverDestinationsManager> provider, Provider<GetExternalSourceAddressDetailInteractor> provider2) {
        this.f26443a = provider;
        this.f26444b = provider2;
    }

    public static UpdateDriverDestinationInteractor_Factory a(Provider<DriverDestinationsManager> provider, Provider<GetExternalSourceAddressDetailInteractor> provider2) {
        return new UpdateDriverDestinationInteractor_Factory(provider, provider2);
    }

    public static UpdateDriverDestinationInteractor c(DriverDestinationsManager driverDestinationsManager, GetExternalSourceAddressDetailInteractor getExternalSourceAddressDetailInteractor) {
        return new UpdateDriverDestinationInteractor(driverDestinationsManager, getExternalSourceAddressDetailInteractor);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public UpdateDriverDestinationInteractor get() {
        return c(this.f26443a.get(), this.f26444b.get());
    }
}
